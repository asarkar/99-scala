package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.*
import P86.colorNodes

class P86Spec extends AnyFunSpec:
  it("graph coloration"):
    val data = List(
      (
        ('a' to 'j').toList,
        List(
          ('a', 'b'),
          ('a', 'e'),
          ('a', 'f'),
          ('b', 'c'),
          ('b', 'g'),
          ('c', 'd'),
          ('c', 'h'),
          ('d', 'e'),
          ('d', 'i'),
          ('e', 'j'),
          ('f', 'h'),
          ('f', 'i'),
          ('g', 'i'),
          ('g', 'j'),
          ('h', 'j')
        )
      ),
      (
        ('A' to 'H').toList,
        List(
          ('A', 'B'),
          ('A', 'H'),
          ('B', 'C'),
          ('B', 'D'),
          ('C', 'E'),
          ('D', 'E'),
          ('D', 'H'),
          ('E', 'F'),
          ('E', 'H'),
          ('F', 'G'),
          ('F', 'H')
        )
      ),
      (
        List('a', 'b', 'c', 'd'),
        List(('a', 'b'), ('b', 'c'), ('a', 'c'), ('a', 'd'))
      )
    )

    data.foreach { (vertices, edges) =>
      val g      = Graph.buildUG(vertices, edges.map((u, v) => Edge(u, v, None)))
      val clrMap = g.colorNodes.toMap
      vertices.foreach { u =>
        g.neighbors(u).map(v => clrMap(v._1)) should not contain (clrMap(u))
      }
    }
