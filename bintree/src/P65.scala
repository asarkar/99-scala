package bintree

import Tree.*

// P65 (**) Layout a binary tree (2).
//     An alternative layout method is depicted in the illustration opposite.
//     Find out the rules and write the corresponding method.
//     Hint: On a given level, the horizontal distance between neighboring nodes is constant.
//
//     scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree2
//     res0: PositionedNode[Char] = T[3,1]('a T[1,2]('b . T[2,3]('c . .)) T[5,2]('d . .))
/*
ANSWER: In this problem, no two nodes share the same Y-coordinate.
Thus, the X-coordinate of a node is determined by the maximum
height of its subtrees. In order to avoid calculating the height of
the tree at every node, we calculate the height of the root tree first.

The nodes on the second level (children of root) are each separated
by 2 * height from the root, the nodes on the next level are
separated by half of the separation value on the level above,
and so on.

We start with the value 2 * height for the separator and halve it
each time when recurring on the children. The X-coordinate of a
node is given by the X-coordinate of its left child plus the
separation value. The X-coordinate of a right child is given by
the by the X-coordinate of its parent plus the separation value.
We also need to handle the special case for the leftmost node with
position 1.
 */
object P65:
  type Pos              = (Int, Int)
  type AnnotatedTree[A] = Tree[(A, Pos)]

  extension [A](t: Tree[A])
    private def height: Int = t match
      case Empty                => -1
      case Node(_, left, right) => 1 + math.max(left.height, right.height)

    def layoutBinaryTree2: AnnotatedTree[A] =
      def loop[A](pos: Int, depth: Int, height: Int, tree: Tree[A]): (AnnotatedTree[A], Int) =
        tree match
          case Empty => (Empty, 0)
          case Node(value, l, r) =>
            val d1           = depth + 1
            val h1           = height / 2
            val (left, lPos) = loop(pos - height, d1, h1, l)
            val pos1         = if lPos > 0 then lPos + height else math.max(pos, 1)
            val (right, _)   = loop(pos1 + height, d1, h1, l)
            val node         = Node((value, (pos1, depth)), left, right)
            (node, pos1)

      loop(1, 1, t.height * 2, t)._1
