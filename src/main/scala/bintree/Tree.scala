package bintree

enum Tree[+A]:
  case Empty
  case Node(value: A, left: Tree[A], right: Tree[A])

object Tree:
  def empty[A]: Tree[A] = Empty

  def singleton[A](x: A): Tree[A] =
    Node(x, Empty, Empty)
