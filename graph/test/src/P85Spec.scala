package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import P85.isIsomorphicTo
import graph.Util.given
import scala.language.implicitConversions

class P85Spec extends AnyFunSpec:
  it("graph isomorphism"):

    val v1                            = List('a', 'b')
    val e1: List[Edge[Char, Nothing]] = List(('a', 'b'))
    val v2                            = List(5, 7)
    val e2: List[Edge[Int, Nothing]]  = List((5, 7))
    val g1                            = Graph.buildUG(v1, e1)
    val g2                            = Graph.buildUG(v2, e2)
    g1.isIsomorphicTo(g2) shouldBe true

    // format: off
    val v3 = (1 to 8).toList
    val e3: List[Edge[Int, Nothing]] =
      List(
        (1, 5), (1, 6), (1, 7), (2, 5),
        (2, 6), (2, 8), (3, 5), (3, 7),
        (3, 8), (4, 6), (4, 7), (4, 8)
      )
    val e4: List[Edge[Int, Nothing]] =
      List(
        (1, 2), (1, 4), (1, 5), (6, 2),
        (6, 5), (6, 7), (8, 4), (8, 5),
        (8, 7), (3, 2), (3, 4), (3, 7)
      )
    // format: on

    val g3 = Graph.buildUG(v3, e3)
    val g4 = Graph.buildUG(v3, e4)
    g3.isIsomorphicTo(g4) shouldBe true

    val v5 = ('a' to 'e').toList
    val e5: List[Edge[Char, Nothing]] =
      List(('a', 'b'), ('a', 'c'), ('a', 'e'), ('b', 'c'), ('c', 'd'), ('d', 'e'))
    val v6 = ('A' to 'E').toList
    val e6: List[Edge[Char, Nothing]] =
      List(('A', 'D'), ('A', 'E'), ('B', 'C'), ('B', 'D'), ('B', 'E'), ('C', 'D'))

    val g5 = Graph.buildUG(v5, e5)
    val g6 = Graph.buildUG(v6, e6)
    g5.isIsomorphicTo(g6) shouldBe true

    val v7 = List('α', 'β', 'γ', 'δ', 'ε')
    val e7: List[Edge[Char, Nothing]] =
      List(('α', 'β'), ('α', 'γ'), ('α', 'ε'), ('β', 'δ'), ('γ', 'δ'), ('δ', 'ε'))
    val g7 = Graph.buildUG(v7, e7)
    g5.isIsomorphicTo(g7) shouldBe false
    g6.isIsomorphicTo(g7) shouldBe false

    val v8 = ('a' to 'f').toList
    val e8: List[Edge[Char, Nothing]] =
      List(('a', 'b'), ('a', 'd'), ('b', 'c'), ('c', 'f'), ('d', 'e'), ('e', 'f'))
    val e9: List[Edge[Char, Nothing]] =
      List(('a', 'd'), ('a', 'e'), ('b', 'd'), ('b', 'f'), ('c', 'e'), ('c', 'f'))
    val g8 = Graph.buildUG(v8, e8)
    val g9 = Graph.buildUG(v8, e9)
    g8.isIsomorphicTo(g9) shouldBe true

    // G(v8 e8) and G(va ea) are not isomorphic but the algorithm can't determine that.
    // val va = [1..6]
    // val ea = [(1, 3), (1, 5), (2, 4), (2, 6), (3, 5), (4, 6)]

    val v10 = ('A' to 'D').toList
    val e10: List[Edge[Char, Nothing]] =
      List(('A', 'B'), ('A', 'C'), ('A', 'D'), ('B', 'C'), ('B', 'D'), ('C', 'D'))
    val v11                           = (1 to 4).toList
    val e11: List[Edge[Int, Nothing]] = List((1, 2), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4))
    val g10                           = Graph.buildUG(v10, e10)
    val g11                           = Graph.buildUG(v11, e11)
    g10.isIsomorphicTo(g11) shouldBe true
