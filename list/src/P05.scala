package list

// P05 (*) Reverse a list.
//     Example:
//     scala> reverse(List(1, 1, 2, 3, 5, 8))
//     res0: List[Int] = List(8, 5, 3, 2, 1, 1)

object P05:

  def reverse[A](l: List[A]): List[A] = reverse(l, Nil)

  private def reverse[A](l: List[A], acc: List[A]): List[A] = l match
    case x :: tail => reverse(tail, x :: acc)
    case Nil       => acc
