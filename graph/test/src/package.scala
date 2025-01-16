package graph

given [A, B] => Conversion[Tuple, Edge[A, B]] =
  case (u, v)    => Edge(u.asInstanceOf[A], v.asInstanceOf[A], None)
  case (u, v, d) => Edge(u.asInstanceOf[A], v.asInstanceOf[A], Some(d.asInstanceOf[B]))
  case _         => throw IllegalArgumentException(s"unsupported tuple")
