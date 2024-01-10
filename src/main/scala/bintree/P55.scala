package bintree

import Tree.*

// P55 (**) Construct completely balanced binary trees.
//     In a completely balanced binary tree, the following property holds for
//     every node: The number of nodes in its left subtree and the number of
//     nodes in its right subtree are almost equal, which means their difference
//     is not greater than one.
//
//     Define an object named Tree.  Write a function Tree.cBalanced to
//     construct completely balanced binary trees for a given number of nodes.
//     The function should generate all solutions.  The function should take as
//     parameters the number of nodes and a single value to put in all of them.
//
//     scala> Tree.cBalanced(4, "x")
//     res0: List(Node[String]) = List(T(x T(x . .) T(x . T(x . .))), T(x T(x . .) T(x T(x . .) .)), ...

object P55:
  private def build[A](n: Int, x: A): List[(Tree[A], Int)] =
    if n == 0
    then Nil
    else if n == 1
    then List((singleton(x), 1))
    else if n == 2
    then
      List(
        (Node(x, singleton(x), Empty), 2),
        (Node(x, Empty, singleton(x)), 2)
      )
    else
      val k = (n - 1) / 2
      for
        (l, i) <- build(k, x)
        (r, j) <- build(n - k - 1, x)
        h = i + j + 1
        xs =
          if math.abs(i - j) == 1
          then List((Node(x, r, l), h))
          else Nil
        y <- (Node(x, l, r), h) :: xs
      yield y

  def cBalanced[A](n: Int, x: A): List[Tree[A]] =
    build(n, x).map(_._1)
