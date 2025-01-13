package bintree

import scala.language.implicitConversions
import P66.layoutBinaryTree3

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.Ignore

@Ignore
class P66Spec extends AnyFunSpec:
  it("layout a binary tree (3)"):
     // format: off
    val xs: Array[Option[Char]] = (
      'n', 'k', 'u', 'c', 'm', 'p',
      None, 'a', 'e', None, None,
      None, 'q', None, None, 'd', 'g'
    )
    val ys: Array[Option[(Char, (Int, Int))]] = (
      ('n', (5, 1)),
      ('k', (3, 2)), ('u', (7, 2)),
      ('c', (2, 3)), ('m', (4, 3)), ('p', (6, 3)), None,
      ('a', (1, 4)), ('e', (3, 4)), None, None, None, ('q', (7, 4)),
      None, None, ('d', (2, 5)), ('g', (4, 5))
    )
     // format: on
    Tree
      .fromArray(xs)
      .layoutBinaryTree3 shouldBe (Tree.fromArray(ys))
