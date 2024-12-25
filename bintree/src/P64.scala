package bintree

import Tree.*

// Problem 64: (**) Layout algorithm for displaying trees.
//     In this layout strategy, the position of a node v is obtained by the following two rules:
//
//     - x(v) is equal to the position of the node v in the inorder sequence
//     - y(v) is equal to the depth of the node v in the tree

//     Write a function to annotate each node of the tree with a position,
//     where (1,1) in the top left corner or the rectangle bounding the drawn tree.
//
//     scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree
//     res0: PositionedNode[Char] = T[3,1](a T[1,2](b . T[2,3](c . .)) T[4,2](d . .))
object P64:
  type Pos              = (Int, Int)
  type AnnotatedTree[A] = Tree[(A, Pos)]

  extension [A](t: Tree[A])
    def layoutBinaryTree: AnnotatedTree[A] =
      def loop[A](pos: Int, depth: Int, tree: Tree[A]): (AnnotatedTree[A], Int) =
        tree match
          case Empty => (Empty, 0)
          case Node(value, l, r) =>
            val (left, lSize)  = loop(pos, depth + 1, l)
            val pos1           = lSize + pos + 1
            val (right, rSize) = loop(pos1, depth + 1, r)
            val node           = Node((value, (pos1, depth)), left, right)
            (node, lSize + rSize + 1)

      loop(0, 1, t)._1
