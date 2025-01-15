package graph

// P85 (**) Graph isomorphism.
// Two graphs G1(N1, E1) and G2(N2, E2) are isomorphic if there is
// a bijection f: N1 -> N2 such that for any nodes X, Y of N1, X
// and Y are adjacent if and only if f(X) and f(Y) are adjacent.
//
// Write a method that determines whether two graphs are isomorphic.
//
// scala> Graph.fromString("[a-b]").isIsomorphicTo(Graph.fromString("[5-7]"))
// res0: Boolean = true

/*
ANSWER:
We apply the Weisfeiler Leman graph isomorphism test.

https://davidbieber.com/post/2019-05-10-weisfeiler-lehman-isomorphism-test/

https://en.wikipedia.org/wiki/Weisfeiler_Leman_graph_isomorphism_test

- At each iteration, the algorithm assigns to each node a tuple
  containing the node's old compressed label and a list of the
  node's neighbors' compressed labels. This is the node's new
  "uncompressed" label.
- The algorithm then groups uncompressed labels and assign a unique
  id to each group that is the "compressed" label for that group.
- If the number of groups is the same as the number of groups in the
  previous iteration, the algorithm does the following:
  - The compressed labels are reduced to a "canonical" form which is
    a sorted list of tuples of the form (label, count).
  - If two graphs have the same canonical form, they may be isomorphic.
    If not, they are certainly not isomorphic.
- If the number of groups is not the same, the algorithm assigns compressed
  labels to each node and continues to the next iteration.
  Any two nodes with the same uncompressed label will get the same
  compressed label.

- The algorithm starts by assigning each node the same compressed label, 0.
- One possible convention for creating compressed labels is to use increasing
  integers starting from 1.

The core idea of the Weisfeiler-Lehman isomorphism test is to find for each
node in each graph a signature based on the neighborhood around the node.
These signatures can then be used to find the correspondance between nodes
in the two graphs, which can be used to check for isomorphism.

In the algorithm descibed above, the "compressed labels" serve as the signatures.
 */
object P85:
  private def lookup[A, B](cl: List[(A, B)])(a: A): B =
    cl.find(_._1 == a).get._2

  private def uncompress[A, B](g: Graph[A, B], cl: List[(A, Int)]): List[(Int, List[Int])] =
    cl.map(u => (u._2, g.neighbors(u._1).toList.map(v => lookup(cl)(v._1)).sorted))

  private def group(
      ucl: List[(Int, List[Int])],
      labelId: Int
  ): List[((Int, List[Int]), (Int, Int))] =
    ucl
      .groupMapReduce(identity)(_ => 1)(_ + _)
      .zip(LazyList.from(labelId + 1))
      .map((xs, k) => (xs._1, (xs._2, k)))
      .toList

  private def compress[A](
      cl1: List[(A, Int)],
      ucl: List[(Int, List[Int])],
      grp: List[((Int, List[Int]), (Int, Int))]
  ): List[(A, Int)] =
    cl1.zip(ucl.map(u => lookup(grp)(u)._2)).map((x, y) => (x._1, y))

  private def canonical(grp: List[((Int, List[Int]), (Int, Int))]): List[(Int, Int)] =
    grp.map(_._2.reverse).sortBy(_._1)

  private def isIsomorphic[A, B, C, D](
      g1: Graph[A, B],
      g2: Graph[C, D]
  )(i: Int, labelId: Int, cl1: List[(A, Int)], cl2: List[(C, Int)], numLabels: Int): Boolean =
    if (g1.size != g2.size) || (i == g1.size) then false
    else
      val ucl1 = uncompress(g1, cl1)
      val ucl2 = uncompress(g2, cl2)
      val grp1 = group(ucl1, labelId)
      val grp2 = group(ucl2, labelId)
      val k    = grp1.size

      if grp2.size == k && numLabels == k then
        val c1 = canonical(grp1)
        val c2 = canonical(grp2)
        c1 == c2
      else
        val cl11 = compress(cl1, ucl1, grp1)
        val cl22 = compress(cl2, ucl2, grp2)
        isIsomorphic(g1, g2)(i + 1, labelId + k, cl11, cl22, k)

  extension [A, B](g1: Graph[A, B])
    def isIsomorphicTo[C, D](g2: Graph[C, D]): Boolean =
      val cl1 = g1.vertices.toList.map((_, 0))
      val cl2 = g2.vertices.toList.map((_, 0))
      isIsomorphic(g1, g2)(0, 0, cl1, cl2, 1)
