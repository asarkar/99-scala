package list

// P09 (**) Pack consecutive duplicates of list elements into sublists.
// If a list contains repeated elements they should be placed in separate
// sublists.
//
// scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

object P09:

  def pack[A](l: List[A]): List[List[A]] =
    l.foldRight(List.empty[List[A]])(pack)

  private def pack[A](x: A, acc: List[List[A]]): List[List[A]] = acc match
    case (y :: ys) :: zs if x == y => (x :: y :: ys) :: zs
    case _                         => List(x) :: acc
