package bintree

import Tree.*

// P59 (**) Construct height-balanced binary trees.
//     In a height-balanced binary tree, the following property holds for every
//     node: The height of its left subtree and the height of its right subtree
//     are almost equal, which means their difference is not greater than one.
//
//     Write a method Tree.hbalTrees to construct height-balanced binary trees
//     for a given height with a supplied value for the nodes.  The function
//     should generate all solutions.
//
//     scala> Tree.hbalTrees(3, "x")
//     res0: List[Node[String]] = List(T(x T(x T(x . .) T(x . .)) T(x T(x . .) T(x . .))), T(x T(x T(x . .) T(x . .)) T(x T(x . .) .)), ...

object P59:
  def hbalTrees[A](h: Int, x: A): List[Tree[A]] =
    if h == 0
    then Nil
    else if h == 1
    then List(singleton(x))
    else if h == 2
    then
      List(
        Node(x, singleton(x), Empty),
        Node(x, Empty, singleton(x)),
        Node(x, singleton(x), singleton(x))
      )
    else
      for
        a <- hbalTrees(h - 1, x)
        b <- hbalTrees(h - 2, x)
        c <- List(
          Node(x, a, b),
          Node(x, b, a),
          Node(x, a, a)
        )
      yield c
