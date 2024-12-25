package bintree

import munit.FunSuite
import scala.language.implicitConversions
import P62.internalList

class P62Suite extends FunSuite:
  test("collect the internal nodes of a binary tree in a list"):
    val data: List[(Array[Option[Char]], List[Char])] = List(
      (('a', 'b'), List('a')),
      (('a', 'b', 'c', None, None, 'd', 'e'), List('a', 'c'))
    )
    data.foreach { (xs, expected) =>
      val obtained = Tree.fromArray(xs).internalList
      assertEquals(obtained, expected)
    }
