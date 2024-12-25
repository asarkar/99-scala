package bintree

import munit.FunSuite
import scala.language.implicitConversions
import P61.leafCount

class P61Suite extends FunSuite:
  test("count the leaves of a binary tree"):
    val data: List[(Array[Option[Char]], Int)] = List(
      (('x', 'x'), 1),
      (('a', 'b', 'c', None, None, 'd', 'e'), 3)
    )

    data.foreach { (xs, expected) =>
      val obtained = Tree.fromArray(xs).leafCount
      assertEquals(obtained, expected)
    }
