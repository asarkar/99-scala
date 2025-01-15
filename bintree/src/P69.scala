package bintree

import Tree.{Empty, Node}

// 69 (**) Dotstring representation of binary trees.
// We consider again binary trees with nodes that are identified by single lower-case letters,
// as in the example of problem P67. Such a tree can be represented by the preorder sequence
// of its nodes in which dots (.) are inserted where an empty subtree (End) is encountered
// during the tree traversal.
// For example, the tree shown in problem P67 is represented as "abd..e..c.fg...".
// First, try to establish a syntax (BNF or syntax diagrams) and then write two methods,
// toDotstring and fromDotstring, which do the conversion in both directions.
//
// scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").toDotstring
// res0: String = abd..e..c.fg...
//
// scala> Tree.fromDotstring("abd..e..c.fg...")
// res1: Node[Char] = a(b(d,e),c(,f(g,)))
object P69:
  extension [A](t: Tree[A])
    def toDotstring: String =
      def loop(tree: Tree[A], acc: List[Char]): List[Char] =
        tree match
          case Empty                    => '.' :: acc
          case Node(value, left, right) => value.toString().head :: loop(left, loop(right, acc))

      loop(t, Nil).mkString

  def fromDotstring(s: String): Tree[Char] =
    def loop(t: String): (Tree[Char], String) =
      t.splitAt(1) match
        case ("", _)   => (Empty, "")
        case (".", xs) => (Empty, xs)
        case (x, xs) =>
          val (left, ys)  = loop(xs)
          val (right, zs) = loop(ys)
          (Node(x.head, left, right), zs)

    loop(s)._1
