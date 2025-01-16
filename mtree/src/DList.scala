package mtree

final case class DList[A](run: List[A] => List[A]):
  // O(1)
  infix def ++(xs: DList[A]): DList[A] = DList(xs.run.andThen(run))

  // O(1)
  def toList: List[A] = run(List.empty[A])

object DList:
  // O(1)
  def empty[A]: DList[A] = DList(identity)

  // O(1)
  def singleton[A]: (A => DList[A]) = a => DList(a :: _)

  // O(n)
  def fromList[A]: (List[A] => DList[A]) = xs => DList(xs ++ _)
