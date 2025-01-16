package mtree

final case class MTree[+T](value: T, children: Seq[MTree[T]] = Nil):
  override def toString: String =
    s"M(${value.toString} {${children.map(_.toString).mkString(",")}})"
