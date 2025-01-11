package bintree

import scala.language.implicitConversions
import P65.layoutBinaryTree2

import org.scalatest.funspec.AnyFunSpec

class P65Spec extends AnyFunSpec:
  it("layout a binary tree (2)"):
     // format: off
    val xs: Array[Option[Char]] = (
      'n', 'k', 'u', 'c', 'm', 'p',
      None, 'a', 'e', None, None,
      None, 'q', None, None, 'd', 'g'
    )
     // format: on
    Tree
      .fromArray(xs)
      .layoutBinaryTree2
      .levelOrder
      .zipAll(xs, None, None)
      .forall:
        case (None, None) => true
        case (x, y) =>
          x.zip(y) match
            case Some((a, b)) if a._1 == b =>
               // format: off
              Set(
                ('n', (15, 1)), ('k', (7, 2)), ('u', (23, 2)), ('c', (3, 3)),
                ('m', (11, 3)), ('p', (19, 3)), ('a', (1, 4)), ('e', (5, 4)),
                ('q', (21, 4)), ('d', (4, 5)), ('g', (6, 5)),
              )
               // format: on
                .contains(a)
            case _ => false
