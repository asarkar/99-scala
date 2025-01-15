package graph

// P82 (*) Cycle from a given node.
// Write a method named findCycles to find closed paths (cycles) starting at a given node
// in a graph.  The method should return all cycles.

// scala> Graph.fromString("[b-c, f-c, g-h, d, f-b, k-f, h-g]").findCycles("f")
// res0: List[List[String]] = List(List(f, c, b, f), List(f, b, c, f))
object P82:
  extension [A, B](g: Graph[A, B])
    def findCycles(u: A): List[List[A]] =
      search(
        u,
        expand =
          (visited, x) => g.neighbors(x).map(_._1).filter(y => y == u || !visited.contains(y)),
        isDone = (visited, x) => x == u && !visited.isEmpty
      )
        // Filter out trivial cycles like 1-2-1
        .filter(_.size > 3)
