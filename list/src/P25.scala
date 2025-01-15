package list

// P25 (*) Generate a random permutation of the elements of a list.
// Hint: Use the solution of problem P23.
//
// scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
// res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

object P25:
  def randomPermute[A](l: List[A]): List[A] =
    P23.randomSelect(Int.MaxValue, l)
