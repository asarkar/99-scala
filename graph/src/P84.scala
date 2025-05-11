package graph

import scala.collection.mutable

// P84 (**) Construct the minimal spanning tree.
//
// Write a method minimalSpanningTree to construct the minimal spanning tree of a given
// labeled graph.  Hint: Use Prim’s Algorithm.  A small modification of the solution of
// P83 does the trick.  The data of the example graph to the right can be found below.
// scala> Graph.fromStringLabel("[a-b/1, b-c/2, a-c/3]").minimalSpanningTree
// res0: Graph[String,Int] = [a-b/1, b-c/2]

/*
ANSWER:
1) Start the algorithm with any node 's'. Mark s as visited
   and add all edges incident to 's' to the  PQ.

2) While the PQ is not empty and a MST has not been formed,
   deque the next minimum cost edge (u, v, d) from the PQ.

3) Repeat step 1 and 2 with the node v.
 */
object P84:

  private def toEdges[A, B](u: A, vs: Set[(A, Option[B])]): List[Edge[A, B]] =
    vs.map(v => Edge(u, v._1, v._2)).toList

  extension [A, B](g: Graph[A, B])
    def minimalSpanningTree(using Ordering[Option[B]]): List[Edge[A, B]] =
      if g.size == 0 then Nil
      else
        // Default is a max queue.
        val q = mutable.PriorityQueue[Edge[A, B]]()(using
          Ordering.by[Edge[A, B], Option[B]](_._3).reverse
        )
        val start = g.edges.head.u
        q.enqueue(toEdges(start, g.neighbors(start))*)
        val visited = mutable.Set(start)

        val xs = List.unfold(()):
          case _ if q.isEmpty => None
          case _ =>
            val e = q.dequeue()
            if visited.contains(e.v) then Some((None, ()))
            else
              visited += e.v
              val xs = g.neighbors(e.v).filter(x => !visited.contains(x._1))
              q.enqueue(toEdges(e.v, xs)*)
              Some((Some(e), ()))

        xs.flatten
