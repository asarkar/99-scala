package bintree

import munit.FunSuite
import scala.language.implicitConversions

class P58Suite extends FunSuite:
  test("construct all symmetric, completely balanced binary trees with a given number of nodes"):
    val obtained = P58.symmetricBalancedTrees(5, 'x')
    val expected: List[Array[Option[Char]]] =
      List(
        ('x', 'x', 'x', None, 'x', 'x'),
        ('x', 'x', 'x', 'x', None, None, 'x')
      )
    assertSameTrees(obtained, expected)
