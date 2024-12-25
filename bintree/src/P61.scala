package bintree

import Tree.*

object P61:
  extension [A](t: Tree[A])
    def leafCount: Int = t match
      case Empty                 => 0
      case Node(_, Empty, Empty) => 1
      case Node(_, left, right)  => left.leafCount + right.leafCount
