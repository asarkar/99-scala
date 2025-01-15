package graph

// P86 (**) Node degree and graph coloration.
// a) Write a method Node.degree that determines the degree of a given node.
//
// scala> Graph.fromString("[a-b, b-c, a-c, a-d]").nodes("a").degree
// res0: Int = 3
//
// b) Write a method that lists all nodes of a graph sorted according to decreasing degree.
//
// scala> Graph.fromString("[a-b, b-c, a-c, a-d]").nodesByDegree
// res1: List[Graph[String,Unit]#Node] = List(Node(a), Node(c), Node(b), Node(d))
//
// c) Use Welsh-Powell’s algorithm to paint the nodes of a graph in such a way that adjacent
// nodes have different colors.  Make a method colorNodes that returns a list of tuples,
// each of which contains a node and an integer representing its color.
//
// scala> Graph.fromString("[a-b, b-c, a-c, a-d]").colorNodes
// res2: List[(Graph[String,Unit]#Node,Int)] = List((Node(a),1), (Node(b),2), (Node(c), 3), (Node(d), 2))

/*
ANSWER:
https://www.youtube.com/watch?v=CQIW2mLfG04

- Sort the vertices in decreasing order of degree.
- Color the top vertex with color 1.
- For any vertex in the list that is not colored,
  and not adjacent to another vertex with color 1,
  color with 1.
- Having walked through the list, if there are any
  remaining vertices, increment color and start
  coloring again.
 */
object P86:

  extension [A, B](g: Graph[A, B])
    private def loop(us: List[A])(vs: List[A], clrMap: Map[A, Int], clr: Int): List[(A, Int)] =
      vs match
        case Nil =>
          if clrMap.size == us.size then clrMap.toList
          else loop(us)(us.filterNot(clrMap.contains), clrMap, clr + 1)
        case v :: xs =>
          val neighboringClrs = g.neighbors(v).map(x => clrMap.getOrElse(x._1, 0))
          val canClr          = !neighboringClrs.contains(clr)

          if canClr then loop(us)(xs, clrMap + (v -> clr), clr)
          else loop(us)(xs, clrMap, clr)

    def colorNodes: List[(A, Int)] =
      val degrees = g.vertices.map(u => (u, g.neighbors(u).size))
      val us      = degrees.toList.sortBy((_, n) => -n).map(_._1)
      loop(us)(us, Map.empty, 1)
