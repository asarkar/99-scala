package bintree

import munit.FunSuite
import Tree.*

class P55Suite extends FunSuite:
  test("construct completely balanced binary trees"):
    val data = List(
      (0, Nil),
      (1, List(singleton('x'))),
      (2, List(Node('x', singleton('x'), Empty), Node('x', Empty, singleton('x')))),
      (3, (List(Node('x', singleton('x'), singleton('x'))))),
      (
        4,
        List(
          Node('x', singleton('x'), Node('x', singleton('x'), Empty)),
          Node('x', Node('x', singleton('x'), Empty), singleton('x')),
          Node('x', singleton('x'), Node('x', Empty, singleton('x'))),
          Node('x', Node('x', Empty, singleton('x')), singleton('x'))
        )
      )
    )
    data.foreach { (n, expected) =>
      val obtained = P55.cBalanced(n, 'x')
      assertEquals(obtained.size, expected.size)
      obtained.foreach { tree =>
        assert(expected.contains(tree), s"Tree: $tree")
      }
    }
