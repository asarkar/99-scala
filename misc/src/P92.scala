package misc

// P92 (***) Von Koch’s conjecture.
// Several years ago I met a mathematician who was intrigued by a problem for which he didn't know
// a solution. His name was Von Koch, and I don't know whether the problem has been solved since.
// [The “I” here refers to the author of the Prolog problems. <PMG>]
//
// Anyway the puzzle goes like this: Given a tree with N nodes (and hence N−1 edges), find a way to
// enumerate the nodes from 1 to N and, accordingly, the edges from 1 to N−1 in such a way, that
// for each edge K the difference of its node numbers is equal to K. The conjecture is that this
// is always possible.
//
// For small trees the problem is easy to solve by hand.However, for larger trees, and 14 is
// already very large, it is extremely difficult to find a solution. And remember, we don’t know
// for sure whether there is always a solution!
//
// Write a function that calculates a numbering scheme for a given tree. What is the solution for
// the larger tree pictured below?
/*
ANSWER: The example diagram provided in the question led me to believe that the vertices should be
labeled such that the label of each edge corresponds to the absolute difference between the node
values/labels. In other words, for an edge (5,2), the edge should have a label of 3, and the
absolute difference between the node labels should be 3.

This (mis)interpretation sent me down a rabbit hole, spending an entire day trying to develop a
solution that adhered to these criteria. I repeatedly inspected my algorithm for bugs, only to
find neither a working solution nor a clear error! It wasn't until I manually drew the two example
graphs and labeled the edges that I realized my misunderstanding.

The only requirement is that the edge and vertex labels must be unique, and that the vertex labels
are in the closed range [1,n], and the edge labels are in the closed range [1,n-1].
See misc/test/resources/92.jpg for examples.

This problem is also known as Graceful labeling (https://en.wikipedia.org/wiki/Graceful_labeling).
It can be solved by DFS with backtracking. We try vertices with higher degrees first
as might prune the search space better.
 */
object P92:
  type Edge = (u: Int, v: Int)

  private case class Args(
      edges: Set[Edge],            // all edges
      remainingVertices: Seq[Int], // vertices yet to be labeled; sorted in desc order of degree
      remainingLabels: Seq[Int],   // vertex labels yet to be used
      edgeLabels: Set[Int],        // used edge labels; two edges can't have the same label
      vertexLabels: Map[Int, Int]  // vertex -> label assignments
  )

  def vonKochLabeling(edges: Set[Edge]): Map[Int, Int] =
    val degrees = P92.degrees(edges)
    // Trying vertices with higher degrees first might constrain labeling more,
    // i.e, prune the search space.
    val vertices =
      edges.flatMap(e => Set(e.u, e.v)).toList.sortBy(degrees(_))(using Ordering[Int].reverse)
    val remainingLabels = 1 to vertices.size
    labelVertex(Args(edges, vertices, remainingLabels, Set.empty, Map.empty))

  private def degrees(edges: Set[Edge]): Map[Int, Int] =
    edges.foldLeft(Map.empty[Int, Int]) { (degrees, e) =>
      List(e.u, e.v).foldLeft(degrees) { (deg, u) =>
        deg.updatedWith(u):
          case None => Some(1)
          case x    => x.map(_ + 1)
      }
    }

  private def neighbors[A](edges: Set[Edge], u: Int): Set[Int] =
    edges
      .filter(e => e.u == u || e.v == u)
      .map(e => if e.u == u then e.v else e.u)

  private def labelVertex(args: Args): Map[Int, Int] =
    val numVertices = args.edges.size + 1

    if args.remainingLabels.isEmpty then
      if args.vertexLabels.size == numVertices then args.vertexLabels
      else Map.empty
    else
      val l  = args.remainingLabels.head
      val u  = args.remainingVertices.head
      val vs = neighbors(args.edges, u)
      val diffs = vs
        .filter(args.vertexLabels.contains)
        .map(v => math.abs(l - args.vertexLabels(v)))

      // If any of the edgeLabels are used already, then this label is no good, try another label.
      if diffs.intersect(args.edgeLabels).nonEmpty then
        labelVertex(args.copy(remainingLabels = args.remainingLabels.tail))
      // Label is unused, assign, and recurse with rest of the vertices and labels.
      else
        val vertexLabels1 = args.vertexLabels + (u -> l)
        val usedLabels    = vertexLabels1.values.toSet
        val labels = labelVertex(
          Args(
            args.edges,
            args.remainingVertices.tail,
            // Compute fresh, not from `remainingLabels`; remainingLabels is used to indicate
            // a failed assignment; i.e. when a label is chosen that had been used before.
            (1 to numVertices).filterNot(usedLabels.contains),
            args.edgeLabels.union(diffs),
            vertexLabels1
          )
        )
        // Found a labeling that works.
        if labels.nonEmpty then labels
        // Backtrack.
        else labelVertex(args.copy(remainingLabels = args.remainingLabels.tail))
