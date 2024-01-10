package bintree

import munit.FunSuite
import Tree.*

class P59Suite extends FunSuite:
  test("construct height-balanced binary trees"):
    val obtained = P59.hbalTrees(3, 'x')
    val expected = List(
      Node('x', Node('x', Empty, Empty), Node('x', Empty, singleton('x'))),
      Node('x', Node('x', Empty, Empty), Node('x', singleton('x'), Empty)),
      Node('x', Node('x', Empty, Empty), Node('x', singleton('x'), singleton('x'))),
      Node('x', Node('x', Empty, singleton('x')), Node('x', Empty, Empty))
    )
    expected.foreach { tree =>
      assert(obtained.contains(tree), s"Tree: $tree")
    }
