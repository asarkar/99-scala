package list

// P21 (*) Insert an element at a given position into a list.
//     Example:
//     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

object P21:

  def insertAt[A](x: A, n: Int, l: List[A]): List[A] =
    val (left, right) = P17.split(n, l)
    left ++ (x :: right)
