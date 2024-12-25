package bintree

import Tree.*

// P61A (*) Collect the leaves of a binary tree in a list.
//     A leaf is a node with no successors.  Write a method leafList to collect them in a list.
//
//     scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
//     res0: List[Char] = List(b, d, e)

object P61A:
  extension [A](t: Tree[A])
    def leafList: List[A] = t match
      case Empty                     => List.empty
      case Node(value, Empty, Empty) => List(value)
      case Node(_, left, right)      => left.leafList ++ right.leafList
