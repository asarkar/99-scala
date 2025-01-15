package list

// P17 (*) Split a list into two parts.
// The length of the first part is given.  Use a Tuple for your result.
//
// scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
object P17:

  def split[A](n: Int, l: List[A]): (List[A], List[A]) = l match
    case Nil          => (Nil, Nil)
    case xs if n == 0 => (Nil, xs)
    case x :: xs =>
      split((n - 1), xs) match
        case (left, right) => (x :: left, right)
