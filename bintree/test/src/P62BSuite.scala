package bintree

import munit.FunSuite
import scala.language.implicitConversions
import P62B.atLevel

class P62BSuite extends FunSuite:
  test("collect the nodes at a given level in a list"):
    val data: List[(Array[Option[Char]], Int, List[Char])] = List(
      (('a', 'b'), 1, List('a')),
      (('a', 'b', 'c', None, None, 'd', 'e'), 2, List('b', 'c'))
    )
    data.foreach { (xs, level, expected) =>
      val obtained = Tree.fromArray(xs).atLevel(level)
      assertEquals(obtained, expected)
    }
