package bintree

import Tree.{Empty, Node}

// P62B (*) Collect the nodes at a given level in a list.
// A node of a binary tree is at level N if the path from the root to the node has length N-1.
// The root node is at level 1.
// Write a method atLevel to collect all nodes at a given level in a list.

// scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
// res0: List[Char] = List(b, c)

object P62B:
  extension [A](t: Tree[A])
    private def loop(level: Int, currLevel: Int, acc: List[A]): List[A] =
      t match
        case Node(value, _, _) if currLevel == level => value :: acc
        case Node(_, left, right) =>
          left.loop(level, currLevel + 1, right.loop(level, currLevel + 1, acc))
        case Empty => acc

    def atLevel(level: Int): List[A] = loop(level, 1, Nil)
