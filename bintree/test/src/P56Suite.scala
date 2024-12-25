package bintree

import munit.FunSuite
import scala.language.implicitConversions
import bintree.P56.isSymmetric

class P56Suite extends FunSuite:
  test("check whether a given binary tree is symmetric"):
    val data: List[(Boolean, Array[Option[Char]])] = List(
      (false, ('a', 'b')),
      (true, ('a', 'b', 'c'))
    )

    data.foreach { (symmetric, xs) =>
      val tree = Tree.fromArray(xs)
      assertEquals(tree.isSymmetric, symmetric)
    }
