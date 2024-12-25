package bintree

import munit.FunSuite
import scala.language.implicitConversions
import P64.layoutBinaryTree

class P64Suite extends FunSuite:
  test("layout a binary tree (1)"):
     // format: off
    val xs: Array[Option[Char]] = (
      'n', 'k', 'u', 'c', 'm', 'p', None,
      'a', 'h', None, None, None, 's',
      None, None, 'g', None, 'q', None, 'e'
    )
     // format: on
    Tree
      .fromArray(xs)
      .layoutBinaryTree
      .levelOrder
      .zipAll(xs, None, None)
      .forall:
        case (None, None) => true
        case (x, y) =>
          x.zip(y) match
            case Some((a, b)) if a._1 == b =>
               // format: off
              Set(
                ('n', (8, 1)), ('k', (6, 2)), ('u', (12, 2)), ('c', (2, 3)),
                ('m', (7, 3)), ('p', (9, 3)), ('a', (1, 4)), ('m', (7, 3)),
                ('h', (5, 4)), ('s', (11, 4)), ('g', (4, 5)), ('q', (10, 5)),
                ('e', (3, 6))
              )
               // format: on
                .contains(a)
            case _ => false
