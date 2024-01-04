package list

// P07 (**) Flatten a nested list structure.
//     Example:
//     scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//     res0: List[Any] = List(1, 1, 2, 3, 5, 8)

object P07:
  def flatten(l: List[Any]): List[Any] = l.foldRight(Nil)(flatten)

  private def flatten(x: Any, acc: List[Any]): List[Any] =
    if x.isInstanceOf[List[Any]]
    then x.asInstanceOf[List[Any]].foldRight(acc)(flatten)
    else x :: acc
