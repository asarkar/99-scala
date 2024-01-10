package bintree

import munit.FunSuite
import Tree.*
import P56.*
import P57.*

class P57Suite extends FunSuite:
  test("add an element to a BST"):
    val xs       = List(3, 2, 5, 7, 1)
    val obtained = xs.foldLeft(Tree.empty[Int])((t, x) => t.addValue(x))
    assertEquals(obtained.isSymmetric, true)

    val ys        = List(3, 2, 5, 7, 4)
    val obtained2 = ys.foldLeft(Tree.empty[Int])((t, x) => t.addValue(x))
    assertEquals(obtained2.isSymmetric, false)
