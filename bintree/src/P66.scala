package bintree

// P66 (***) Layout a binary tree (3).
//     Yet another layout strategy is shown in the illustration opposite.
//     The method yields a very compact layout while maintaining a certain symmetry in every node.
//     Find out the rules and write the corresponding method.
//     Hint: Consider the horizontal distance between a node and its successor nodes.
//     How tight can you pack together two subtrees to construct the combined binary tree?
//     Use the same conventions as in problem P64 and P65.
//
//     scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree3
//     res0: PositionedNode[Char] = T[2,1]('a T[1,2]('b . T[2,3]('c . .)) T[3,2]('d . .))
/*
ANSWER: ???
 */
object P66:
  type Pos              = (Int, Int)
  type AnnotatedTree[A] = Tree[(A, Pos)]

  extension [A](t: Tree[A])

    def layoutBinaryTree3: AnnotatedTree[A] = ???
