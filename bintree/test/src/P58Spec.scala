package bintree

import scala.language.implicitConversions

import org.scalatest.funspec.AnyFunSpec

class P58Spec extends AnyFunSpec:
  it("construct all symmetric, completely balanced binary trees with a given number of nodes"):
    val obtained = P58.symmetricBalancedTrees(5, 'x')
    val expected: List[Array[Option[Char]]] =
      List(
        ('x', 'x', 'x', None, 'x', 'x'),
        ('x', 'x', 'x', 'x', None, None, 'x')
      )
    assertSameTrees(obtained, expected)
