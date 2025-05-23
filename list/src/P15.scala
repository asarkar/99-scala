package list

// P15 (**) Duplicate the elements of a list a given number of times.
//
// scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
// res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

object P15:

  def duplicateN[A](n: Int, l: List[A]): List[A] =
    l.flatMap(x => List.fill(n)(x))
