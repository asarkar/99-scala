package bintree

import Tree.{Empty, Node}

// P61 (*) Count the leaves of a binary tree.
// A leaf is a node with no successors.  Write a method leafCount to count them.
//
// scala> Node('x', Node('x'), End).leafCount
// res0: Int = 1
object P61:
  extension [A](t: Tree[A])
    def leafCount: Int = t match
      case Empty                 => 0
      case Node(_, Empty, Empty) => 1
      case Node(_, left, right)  => left.leafCount + right.leafCount
