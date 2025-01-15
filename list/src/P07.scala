package list

// P07 (**) Flatten a nested list structure.
//
// scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
// res0: List[Any] = List(1, 1, 2, 3, 5, 8)

object P07:
  def flatten[A](l: List[A | List[A]]): List[A] = l.foldRight(List.empty[A])(flatten)

  private def flatten[A](x: A | List[A], acc: List[A]): List[A] =
    // Can't check for instanceOf(List[A]) since
    // A vanishes at runtime (type erasure).
    if x.isInstanceOf[List[Any]]
    then x.asInstanceOf[List[A]].foldRight(acc)(flatten)
    else x.asInstanceOf[A] :: acc
