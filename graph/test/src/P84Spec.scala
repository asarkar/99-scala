package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.*
import P84.minimalSpanningTree
import org.scalactic.Equality

class P84Spec extends AnyFunSpec:
  it("construct the minimal spanning tree"):
    val data = List(
      (
        List('a', 'b', 'c'),
        List(('a', 'b', 1), ('b', 'c', 2), ('a', 'c', 3)),
        3
      ),
      (
        List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'),
        List(
          ('a', 'b', 5),
          ('a', 'd', 3),
          ('b', 'c', 2),
          ('b', 'e', 4),
          ('c', 'e', 6),
          ('d', 'e', 7),
          ('d', 'f', 4),
          ('d', 'g', 3),
          ('e', 'h', 5),
          ('f', 'g', 4),
          ('g', 'h', 1)
        ),
        22
      )
    )

    val edgeEq = new Equality[(Char, Char, Int)]:
      def areEqual(a: (Char, Char, Int), b: Any): Boolean =
        if b.isInstanceOf[Edge[?, ?]] then
          val e = b.asInstanceOf[Edge[Char, Int]]
          (a._1, a._2) == (e.u, e.v) || (a._1, a._2) == (e.v, e.u)
        else false

    data.foreach { (vertices, edges, cost) =>
      val g   = Graph.buildUG(vertices, edges.map((u, v, d) => Edge(u, v, Some(d))))
      val mst = g.minimalSpanningTree
      mst.foreach(e => (edges should contain(e))(edgeEq))
      mst.foldLeft(0)((s, e) => s + e.data.getOrElse(0)) shouldBe cost
    }
