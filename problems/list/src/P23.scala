package list

import scala.util.Random

// P23 (**) Extract a given number of randomly selected elements from a list.
//     Example:
//     scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
//     res0: List[Symbol] = List('e, 'd, 'a)
//
//     Hint: Use the answer to P20.

object P23:
  def randomSelect[A](n: Int, l: List[A]): List[A] =
    val k = l.size
    val m = n.min(k)
    val r = Random()

    (0 until m).foldLeft((l, List.empty[A])) { case ((xs, acc), i) =>
      val x       = r.nextInt(k - i)
      val (ys, y) = P20.removeAt(x, xs)
      (ys, y :: acc)
    }(1)
