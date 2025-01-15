package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.*
import P83.spanningTrees
import org.scalactic.Equality

class P83Spec extends AnyFunSpec:
  it("construct all spanning trees"):
    val data = List(
      (
        List('a', 'b', 'c'),
        List(('a', 'b'), ('b', 'c'), ('a', 'c'))
      ),
      (
        List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'),
        List(
          ('a', 'b'),
          ('a', 'd'),
          ('b', 'c'),
          ('b', 'e'),
          ('c', 'e'),
          ('d', 'e'),
          ('d', 'f'),
          ('d', 'g'),
          ('e', 'h'),
          ('f', 'g'),
          ('g', 'h')
        )
      )
    )

    val edgeEq = new Equality[(Char, Char)]:
      def areEqual(a: (Char, Char), b: Any): Boolean =
        if b.isInstanceOf[List[?]] then
          b.asInstanceOf[List[Char]] match
            case u :: v :: Nil => (u, v) == a || (v, u) == a
            case _             => false
        else false

    data.foreach { (vertices, edges) =>
      val g  = Graph.buildUG(vertices, edges.map((u, v) => Edge(u, v, None)))
      val st = g.spanningTrees
      val n  = g.vertices.size
      st.foreach { t =>
        t.size shouldBe n
        t.sliding(2).foreach(e => (edges should contain(e))(edgeEq))
      }
    }
