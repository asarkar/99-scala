package bintree

import munit.FunSuite
import scala.language.implicitConversions

class P59Suite extends FunSuite:
  test("construct height-balanced binary trees"):
    val obtained = P59.hbalTrees(3, 'x')
    val expected: List[Array[Option[Char]]] = List(
      ('x', 'x', 'x', None, None, None, 'x'),
      ('x', 'x', 'x', None, None, 'x'),
      ('x', 'x', 'x', None, None, 'x', 'x'),
      ('x', 'x', 'x', None, 'x')
    )
    expected.foreach { xs =>
      assert(obtained.contains(Tree.fromArray(xs)))
    }
