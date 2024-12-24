package bintree

import Tree.*

// P56 (**) Symmetric binary trees.
//     Let us call a binary tree symmetric if you can draw a vertical line
//     through the root node and then the right subtree is the mirror image of
//     the left subtree.  Add an isSymmetric method to the Tree class to check
//     whether a given binary tree is symmetric.  Hint: Write an isMirrorOf
//     method first to check whether one tree is the mirror image of another.
//     We are only interested in the structure, not in the contents of the
//     nodes.
//
//     scala> Node('a', Node('b'), Node('c')).isSymmetric
//     res0: Boolean = true

object P56:
  private def isMirror[A](t1: Tree[A], t2: Tree[A]): Boolean =
    (t1, t2) match
      case (Empty, Empty) => true
      case (Empty, _)     => false
      case (_, Empty)     => false
      case (Node(_, l1, r1), Node(_, l2, r2)) =>
        isMirror(l1, r2) && isMirror(r1, l2)

  extension [A](t: Tree[A])
    def isSymmetric: Boolean = t match
      case Empty         => true
      case Node(_, l, r) => isMirror(l, r)
