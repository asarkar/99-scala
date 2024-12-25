package bintree

import munit.FunSuite
import scala.language.implicitConversions
import P68.{preorder, inorder}

class P68Suite extends FunSuite:
  // format: off
  private val xs: Array[Option[Char]] = (
    'a', 'b', 'c', 'd', 'e', None,
    'f', None, None, None, None, 'g'
  )
  // format: on

  test("preorder sequence of binary trees"):
    val obtained = Tree.fromArray(xs).preorder
    val expected = List('a', 'b', 'd', 'e', 'c', 'f', 'g')

    assertEquals(obtained, expected)

  test("inorder sequence of binary trees"):
    val obtained = Tree.fromArray(xs).inorder
    val expected = List('d', 'b', 'e', 'a', 'c', 'g', 'f')

    assertEquals(obtained, expected)

  test("preorder and inorder sequences of binary trees"):
    val tree     = Tree.fromArray(xs)
    val obtained = P68.preInTree(tree.preorder, tree.inorder)

    assertEquals(obtained, tree)
