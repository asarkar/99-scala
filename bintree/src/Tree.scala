package bintree

enum Tree[+A]:
  case Empty
  case Node(value: A, left: Tree[A], right: Tree[A])

  override def toString(): String = this match
    case Empty                    => "."
    case Node(value, left, right) => s"T($value $left $right)"

  def levelOrder: List[Option[A]] = this match
    case Empty => List.empty
    case node =>
      val xs = List.unfold(List(node)):
        case Nil => None
        case nodes =>
          Some(nodes.foldRight((List.empty[Option[A]], List.empty[Tree[A]])) { (t, acc) =>
            t match
              case Node(value, l, r) => (Some(value) :: acc._1, l :: r :: acc._2)
              case Empty             => (None :: acc._1, acc._2)
          })
      xs.flatten.reverse.dropWhile(_.isEmpty).reverse

object Tree:
  def empty[A]: Tree[A] = Empty

  def singleton[A](x: A): Tree[A] =
    Node(x, Empty, Empty)

  def fromArray[A](xs: Array[Option[A]]): Tree[A] =
    def loop(ys: Array[Option[A]], n: Int): List[Tree[A]] =
      if ys.isEmpty then List.empty
      else
        val (currLevel, rest) = ys.splitAt(n)
        val k                 = currLevel.count(!_.isEmpty) * 2
        currLevel
          .foldLeft((List.empty[Tree[A]], loop(rest, k))) { (acc, t) =>
            t match
              case None => (Empty :: acc._1, acc._2)
              case Some(value) =>
                val (children, rest) = acc._2.splitAt(2)
                val x = children match
                  case l :: r :: Nil => Node(value, l, r)
                  case l :: Nil      => Node(value, l, Empty)
                  case _             => singleton(value)
                (x :: acc._1, rest)
          }
          .ensuring(_._2.isEmpty, s"unused nodes")
          ._1
          .reverse

    loop(xs, 1) match
      case head :: _ => head
      case Nil       => Empty
