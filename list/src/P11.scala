package list

// P11 (*) Modified run-length encoding.
// Modify the result of problem P10 in such a way that if an element has no
// duplicates it is simply copied into the result list.  Only elements with
// duplicates are transferred as (N, E) terms.
//
// scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

object P11:

  def encodeModified[A](l: List[A]): List[A | (Int, A)] =
    P09
      .pack(l)
      // size takes O(n) time on lists.
      .map(xs => if xs.tail.isEmpty then xs.head else (xs.size, xs.head))
