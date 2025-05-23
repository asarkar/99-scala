package bintree

import scala.language.implicitConversions
import P65.layoutBinaryTree2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P65Spec extends AnyFunSpec:
  it("layout a binary tree (2)"):
     // format: off
    val xs: Array[Option[Char]] = (
      'n', 'k', 'u', 'c', 'm', 'p',
      None, 'a', 'e', None, None,
      None, 'q', None, None, 'd', 'g'
    )
    val ys: Array[Option[(Char, (Int, Int))]] = (
      ('n', (15, 1)),
      ('k', (7, 2)), ('u', (23, 2)),
      ('c', (3, 3)), ('m', (11, 3)), ('p', (19, 3)), None,
      ('a', (1, 4)), ('e', (5, 4)), None, None, None, ('q', (21, 4)),
      None, None, ('d', (4, 5)), ('g', (6, 5))
    )
     // format: on
    Tree
      .fromArray(xs)
      .layoutBinaryTree2 shouldBe (Tree.fromArray(ys))
