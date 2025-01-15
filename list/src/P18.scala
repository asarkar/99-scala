package list

// P18 (**) Extract a slice from a list.
// Given two indices, I and K, the slice is the list containing the elements
// from and including the Ith element up to but not including the Kth
// element of the original list.  Start counting the elements with 0.
//
// scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: List[Symbol] = List('d, 'e, 'f, 'g)
object P18:

  def slice[A](start: Int, end: Int, l: List[A]): List[A] =
    if end < start
    then throw new IllegalArgumentException("invalid bounds")
    else P17.split(start, l)(1).take(end - start)
