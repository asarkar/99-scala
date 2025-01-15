package bintree

import Tree.{Empty, Node}

// P61A (*) Collect the leaves of a binary tree in a list.
// A leaf is a node with no successors.  Write a method leafList to collect them in a list.
//
// scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
// res0: List[Char] = List(b, d, e)

object P61A:
  extension [A](t: Tree[A])
    private def loop(leaves: List[A]): List[A] =
      t match
        case Empty                     => leaves
        case Node(value, Empty, Empty) => value :: leaves
        case Node(_, left, right)      => left.loop(right.loop(leaves))

    def leafList: List[A] = loop(Nil)
