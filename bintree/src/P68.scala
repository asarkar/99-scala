package bintree

import Tree.*

// P68 (**) Preorder and inorder sequences of binary trees.
//     We consider binary trees with nodes that are identified by single lower-case letters,
//     as in the example of problem P67.
//
//     a) Write methods preorder and inorder that construct the preorder and inorder sequence
//        of a given binary tree, respectively. The results should be lists.
//
//     scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").preorder
//     res0: List[Char] = List(a, b, d, e, c, f, g)

//     scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").inorder
//     res1: List[Char] = List(d, b, e, a, c, g, f)
//
//     b) If both the preorder sequence and the inorder sequence of the nodes of a binary tree
//        are given, then the tree is determined unambiguously. Write a method preInTree that does the job.
//
//     scala> Tree.preInTree(List('a', 'b', 'd', 'e', 'c', 'f', 'g'), List('d', 'b', 'e', 'a', 'c', 'g', 'f'))
//     res2: Node[Char] = a(b(d,e),c(,f(g,)))
//
//     What happens if the same character appears in more than one node?
//     Try, for instance, Tree.preInTree(List('a', 'b', 'a'), List('b', 'a', 'a')).

/*
ANSWER: We take each element from the preorder and find it in the inorder.
This is the root value, the left sequence is the left tree, and the right
sequence is the right tree. We recurse on the left and the right subtrees.

In addition to returning the node, we also return the preorder string that
is yet to be processed.
 */
object P68:
  extension [A](t: Tree[A])
    def preorder: List[Char] =
      t match
        case Empty                    => Nil
        case Node(value, left, right) => (value.toString().head :: left.preorder) ++ right.preorder

    def inorder: List[Char] =
      t match
        case Empty                    => Nil
        case Node(value, left, right) => left.inorder ++ (value.toString().head :: right.inorder)

  def preInTree(pre: List[Char], in: List[Char]): Tree[Char] =
    def loop(pre: List[Char], in: List[Char]): (Tree[Char], List[Char]) =
      pre match
        case head :: tail if in.size == 1 => (singleton(head), tail)
        case head :: tail if in.size > 1 =>
          val (leftIn, rightIn) = in.span(_ != head)
          val (left, xs)        = loop(tail, leftIn)
          val (right, ys)       = loop(xs, rightIn.tail)
          (Node(head, left, right), ys)
        case _ => (Empty, pre)

    loop(pre, in)._1
