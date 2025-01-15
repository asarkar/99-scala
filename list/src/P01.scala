package list

// P01 (*) Find the last element of a list.
//
// scala> last(List(1, 1, 2, 3, 5, 8))
// res0: Int = 8

object P01:
  def last[A](l: List[A]): A = l match
    case lst :: Nil => lst
    case _ :: tail  => last(tail)
    case Nil        => throw new NoSuchElementException("last of empty list")
