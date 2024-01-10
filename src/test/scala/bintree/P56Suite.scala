package bintree

import munit.FunSuite
import Tree.*
import P56.*

class P56Suite extends FunSuite:
  test("check whether a given binary tree is symmetric"):
    val obtained = Node('a', singleton('b'), Empty).isSymmetric
    assertEquals(obtained, false)

    val obtained2 = Node('a', singleton('b'), singleton('c')).isSymmetric
    assertEquals(obtained2, true)
