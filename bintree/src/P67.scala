package bintree

import Tree.*

// P67 (**) A string representation of binary trees.
// Somebody represents binary trees as strings of the following type (see example opposite):
// a(b(d,e),c(,f(g,)))
// Write a method which generates this string representation, if the tree is given as usual
// (in Nodes and Ends).  Use that method for the Tree class's and subclass's toString methods.
// Then write a method (on the Tree object) which does this inverse; i.e. given the string
// representation, construct the tree in the usual form.
//
// For simplicity, suppose the information in the nodes is a single letter and there are no spaces in the string.
//
// scala> Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))).toString
// res0: String = a(b(d,e),c(,f(g,)))
//
// scala> Tree.fromString("a(b(d,e),c(,f(g,)))")
// res1: Node[Char] = a(b(d,e),c(,f(g,)))
object P67:
  def toString[A](tree: Tree[A]): String =
    tree match
      case Empty                     => ""
      case Node(value, Empty, Empty) => value.toString()
      case Node(value, left, right)  => s"$value(${P67.toString(left)},${P67.toString(right)})"

  def fromString(s: String): Tree[Char] =
    def parse(start: Int): (Tree[Char], Int) =
      if start >= s.length() || !s(start).isLetterOrDigit then (Empty, start + 1)
      else if start < s.length() - 1 && s(start + 1) == '(' then // left
        val (left, startRight) = parse(start + 2)
        val (right, next)      = parse(startRight)
        (Node(s(start), left, right), next)
      else // right
        val nextComma = s.indexOf(',', start + 1)
        (singleton(s(start)), if nextComma >= start then nextComma + 1 else s.length())

    parse(0)._1
