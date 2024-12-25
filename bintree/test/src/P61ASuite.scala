package bintree

import munit.FunSuite
import scala.language.implicitConversions
import P61A.leafList

class P61ASuite extends FunSuite:
  test("collect the leaves of a binary tree in a list"):
    val data: List[(Array[Option[Char]], List[Char])] = List(
      (('x', 'x'), List('x')),
      (('a', 'b', 'c', None, None, 'd', 'e'), List('b', 'd', 'e'))
    )
    data.foreach { (xs, expected) =>
      val obtained = Tree.fromArray(xs).leafList
      assertEquals(obtained, expected)
    }
