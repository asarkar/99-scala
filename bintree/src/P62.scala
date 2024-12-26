package bintree

import Tree.*

// P62 (*) Collect the internal nodes of a binary tree in a list.
//     An internal node of a binary tree has either one or two non-empty successors.
//     Write a method internalList to collect them in a list.
//
//     scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
//     res0: List[Char] = List(a, c)

object P62:
  extension [A](t: Tree[A])
    def internalList: List[A] =
      def loop(tree: Tree[A], leaves: List[A]): List[A] =
        tree match
          case Empty                    => leaves
          case Node(_, Empty, Empty)    => leaves
          case Node(value, left, right) => loop(left, value :: loop(right, leaves))

      loop(t, Nil)
