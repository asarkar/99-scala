package list

// P13 (**) Run-length encoding of a list (direct solution).
//     Implement the so-called run-length encoding data compression method
//     directly.  I.e. don't use other methods you've written (like P09's
//     pack); do all the work directly.
//
//     Example:
//     scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

object P13:

  def encodeDirect[A](l: List[A]): List[(Int, A)] =
    l.foldRight(List.empty[(Int, A)]):
      case (x, Nil)                           => List((1, x))
      case (x, acc @ ((_, y) :: _)) if x != y => (1, x) :: acc
      case (_, (n, y) :: ys)                  => (n + 1, y) :: ys
