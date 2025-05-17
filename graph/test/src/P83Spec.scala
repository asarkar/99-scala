package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.*
import P83.spanningTrees
import org.scalactic.Equality
import graph.Util.given
import org.scalatest.Inspectors.forAll

import scala.language.implicitConversions

class P83Spec extends AnyFunSpec:
  it("construct all spanning trees"):
    val data: List[(List[Char], List[Edge[Char, Nothing]])] = List(
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

    val edgeEq = new Equality[Edge[Char, Nothing]]:
      def areEqual(a: Edge[Char, Nothing], b: Any): Boolean =
        if b.isInstanceOf[List[?]] then
          b.asInstanceOf[List[Char]] match
            case u :: v :: Nil => (u, v) == (a.u, a.v) || (v, u) == (a.u, a.v)
            case _             => false
        else false

    forAll(data) { (vertices, edges) =>
      val g  = Graph.buildUG(vertices, edges)
      val st = g.spanningTrees
      val n  = g.vertices.size
      forAll(st) { t =>
        t.size shouldBe n
        t.sliding(2).foreach(e => (edges should contain(e))(using edgeEq))
      }
    }
