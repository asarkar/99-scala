package graph

import P86.colorNodes

// P89 (**) Bipartite graphs.
// Write a function that determines whether a given graph is bipartite.
//
// scala> Digraph.fromString("[a>b, c>a, d>b]").isBipartite
// res0: Boolean = true
//
// scala> Graph.fromString("[a-b, b-c, c-a]").isBipartite
// res1: Boolean = false
//
// scala> Graph.fromString("[a-b, b-c, d]").isBipartite
// res2: Boolean = true
//
// scala> Graph.fromString("[a-b, b-c, d, e-f, f-g, g-e, h]").isBipartite
// res3: Boolean = false
//
// ANSWER: A bipartite graph is always 2-colorable, and vice-versa.
object P89:

  extension [A, B](g: Graph[A, B])

    def isBipartite: Boolean =
      g.colorNodes.map(_._2).toSet.size == 2
