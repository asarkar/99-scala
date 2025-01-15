package list

import java.util.NoSuchElementException

// P03 (*) Find the Kth element of a list.
// By convention, the first element in the list is element 0.
//
// scala> nth(2, List(1, 1, 2, 3, 5, 8))
// res0: Int = 2

object P03:
  def nth[A](n: Int, l: List[A]): A = l match
    case x :: _ if n == 0 => x
    case x :: tail        => nth(n - 1, tail)
    case Nil              => throw NoSuchElementException("n too large")
