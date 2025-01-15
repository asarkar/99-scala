package list

// P22 (*) Create a list containing all integers within a given range.
//
// scala> range(4, 9)
// res0: List[Int] = List(4, 5, 6, 7, 8, 9)

object P22:
  def range(start: Int, end: Int): List[Int] =
    if end < start
    then throw new IllegalArgumentException("invalid bounds")
    else if start == end
    then List(start)
    else start :: range(start + 1, end)
