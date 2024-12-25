package bintree

import Tree.*

// P62B (*) Collect the nodes at a given level in a list.
//     A node of a binary tree is at level N if the path from the root to the node has length N-1.
//     The root node is at level 1.
//     Write a method atLevel to collect all nodes at a given level in a list.

//     scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
//     res0: List[Char] = List(b, c)

object P62B:
  extension [A](t: Tree[A])
    def atLevel(level: Int, tree: Tree[A] = t, currLevel: Int = 1): List[A] = tree match
      case Node(value, _, _) if currLevel == level => List(value)
      case Node(_, left, right) => atLevel(level, left, currLevel + 1) ++ atLevel(level, right, currLevel + 1)
      case Empty                => List.empty
