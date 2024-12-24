package bintree

import munit.FunSuite
import Tree.*

class P58Suite extends FunSuite:
  test("construct all symmetric, completely balanced binary trees with a given number of nodes"):
    val obtained = P58.symmetricBalancedTrees(5, 'x')
    val expected = List(
      Node('x', Node('x', Empty, singleton('x')), Node('x', singleton('x'), Empty)),
      Node('x', Node('x', singleton('x'), Empty), Node('x', Empty, singleton('x')))
    )
    assertEquals(obtained.size, expected.size)
    obtained.foreach { tree =>
      assert(expected.contains(tree), s"Tree: $tree")
    }
