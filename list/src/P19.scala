package list

// P19 (**) Rotate a list N places to the left.
//
// scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
//
// scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

object P19:

  def rotate[A](n: Int, l: List[A]): List[A] =
    val k             = Math.floorMod(n, l.size)
    val (left, right) = P17.split(k, l)
    right ++ left
