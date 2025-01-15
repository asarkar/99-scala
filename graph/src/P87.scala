package graph

// P87 (**) Depth-first order graph traversal.
// Write a method that generates a depth-first order graph traversal sequence.
// The starting point should be specified, and the output should be a list of
// nodes that are reachable from this starting point (in depth-first order).
//
// scala> Graph.fromString("[a-b, b-c, e, a-c, a-d]").nodesByDepthFrom("d")
// res0: List[String] = List(c, b, a, d)
object P87:

  extension [A, B](g: Graph[A, B])

    def nodesByDepthFrom(u: A, visited: Set[A] = Set.empty[A]): Set[A] =
      if visited.contains(u) then visited
      else
        g
          .neighbors(u)
          .map(_._1)
          .filterNot(visited.contains)
          .foldLeft(visited + u)((vis, v) => nodesByDepthFrom(v, vis))
