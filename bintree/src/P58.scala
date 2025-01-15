package bintree

import P56.isSymmetric

// P58 (**) Generate-and-test paradigm.
// Apply the generate-and-test paradigm to construct all symmetric,
// completely balanced binary trees with a given number of nodes.
//
// scala> Tree.symmetricBalancedTrees(5, "x")
// res0: List[Node[String]] = List(T(x T(x . T(x . .)) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . T(x . .))))

object P58:
  def symmetricBalancedTrees[A](n: Int, x: A): List[Tree[A]] =
    P55.cBalanced(n, x).filter(_.isSymmetric)
