package list

// P20 (*) Remove the Kth element from a list.
//     Return the list and the removed element in a Tuple.  Elements are
//     numbered from 0.
//
//     Example:
//     scala> removeAt(1, List('a, 'b, 'c, 'd))
//     res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

object P20:

  def removeAt[A](n: Int, l: List[A]): (List[A], A) =
    P17.split(n, l) match
      case (_, Nil)      => throw new NoSuchElementException("n too large")
      case (left, right) => (left ++ right.tail, right.head)
