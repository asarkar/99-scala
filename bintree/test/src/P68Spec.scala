package bintree

import scala.language.implicitConversions
import P68.{preorder, inorder}

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P68Spec extends AnyFunSpec:
  // format: off
  private val xs: Array[Option[Char]] = (
    'a', 'b', 'c', 'd', 'e', None,
    'f', None, None, None, None, 'g'
  )
  // format: on

  it("preorder sequence of binary trees"):
    val obtained = Tree.fromArray(xs).preorder
    val expected = List('a', 'b', 'd', 'e', 'c', 'f', 'g')

    obtained shouldBe expected

  it("inorder sequence of binary trees"):
    val obtained = Tree.fromArray(xs).inorder
    val expected = List('d', 'b', 'e', 'a', 'c', 'g', 'f')

    obtained shouldBe expected

  it("preorder and inorder sequences of binary trees"):
    val tree     = Tree.fromArray(xs)
    val obtained = P68.preInTree(tree.preorder, tree.inorder)

    obtained shouldBe tree
