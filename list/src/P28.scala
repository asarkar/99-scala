package list

// P28 (**) Sorting a list of lists according to length of sublists.
// a) We suppose that a list contains elements that are lists themselves.
//    The objective is to sort the elements of the list according to their
//    length.  E.g. short lists first, longer lists later, or vice versa.
//
//    scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
//    res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
//
// b) Again, we suppose that a list contains elements that are lists
//    themselves.  But this time the objective is to sort the elements
//    according to their length frequency; i.e. in the default, sorting is
//    done ascendingly, lists with rare lengths are placed, others with a
//    more frequent length come later.
//
//    scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
//    res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
//
// Note that in the above example, the first two lists in the result have
// length 4 and 1 and both lengths appear just once.  The third and fourth
// lists have length 3 and there are two list of this length.  Finally, the
// last three lists have length 2.  This is the most frequent length.

object P28:
  def lsort[A](l: List[List[A]]): List[List[A]] =
    l.sortBy(_.length)

  def lsortFreq[A](l: List[List[A]]): List[List[A]] =
    val ls = l.foldLeft(Map.empty[Int, Int])((acc, xs) =>
      acc.updatedWith(xs.length)(_.map(_ + 1).orElse(Some(1)))
    )
    l.sortBy(xs => ls(xs.length))
