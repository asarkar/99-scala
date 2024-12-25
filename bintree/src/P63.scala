package bintree

import Tree.*

// P63 (**) Construct a complete binary tree.
//     A complete binary tree with height H is defined as follows: The levels
//     1,2,3,...,H-1 contain the maximum number of nodes (i.e. 2^(i-1) at the
//     level i, note that we start counting the levels from 1 at the root).
//     In level H, which may contain less than the maximum possible number of nodes,
//     all the nodes are "left-adjusted".
//     Write a method completeBinaryTree that takes as parameters the number of
//     nodes and the value to put in each node.
//
//     scala> Tree.completeBinaryTree(6, "x")
//     res0: Node[String] = T(x T(x T(x . .) T(x . .)) T(x T(x . .) .))
object P63:
  def completeBinaryTree[A](n: Int, a: A, i: Int = 1): Tree[A] =
    if i > n then Empty
    else Node(a, completeBinaryTree(n, a, 2 * i), completeBinaryTree(n, a, 2 * i + 1))
