package list

// P10 (*) Run-length encoding of a list.
// Use the result of problem P09 to implement the so-called run-length
// encoding data compression method.  Consecutive duplicates of elements are
// encoded as tuples (N, E) where N is the number of duplicates of the
// element E.
//
// scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

object P10:

  def encode[A](l: List[A]): List[(Int, A)] =
    // size takes O(n) time on lists.
    P09.pack(l).map(xs => (xs.size, xs.head))
