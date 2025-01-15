package graph

// P81 (**) Path from one node to another one.
// Write a method named findPaths to find acyclic paths from one node to another in a graph.
// The method should return all paths.

// scala> Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").findPaths("p", "q")
// res0: List[List[String]] = List(List(p, q), List(p, m, q))

// scala> Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").findPaths("p", "k")
// res1: List[List[String]] = List()
object P81:
  extension [A, B](g: Graph[A, B])
    def findPaths(u: A, v: A): List[List[A]] =
      search(
        u,
        expand = (visited, x) => g.neighbors(x).map(_._1).filterNot(visited.contains),
        isDone = (visited, x) => x == v
      )
