package graph

import P87.nodesByDepthFrom

// P88 (**) Connected components.
// Write a function that splits a graph into its connected components.
//
// scala> Graph.fromString("[a-b, c]").splitGraph
// res0: List[Graph[String,Unit]] = List([a-b], [c])
object P88:

  extension [A, B](g: Graph[A, B])

    def splitGraph: Iterable[Set[A]] =
      Set.unfold(g.vertices) { xs =>
        Option.unless(xs.isEmpty):
          val u       = xs.head
          val visited = g.nodesByDepthFrom(u)
          (visited, xs -- visited)
      }
