package bintree

import scala.language.implicitConversions
import P64.layoutBinaryTree

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P64Spec extends AnyFunSpec:
  it("layout a binary tree (1)"):
     // format: off
    val xs: Array[Option[Char]] = (
      'n', 'k', 'u', 'c', 'm', 'p', None,
      'a', 'h', None, None, None, 's',
      None, None, 'g', None, 'q', None, 'e'
    )

    val ys: Array[Option[(Char, (Int, Int))]] = (
      ('n', (8, 1)),
      ('k', (6, 2)), ('u', (12, 2)),
      ('c', (2, 3)), ('m', (7, 3)), ('p', (9, 3)), None,
      ('a', (1, 4)), ('h', (5, 4)), None, None, None, ('s', (11, 4)),
      None, None, ('g', (4, 5)), None, ('q', (10, 5)), None,
      ('e', (3, 6))
    )
     // format: on
    Tree
      .fromArray(xs)
      .layoutBinaryTree shouldBe (Tree.fromArray(ys))
