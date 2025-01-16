package graph

def search[A](
    start: A,
    expand: (Set[A], A) => Iterable[A],
    isDone: (Set[A], A) => Boolean
): List[List[A]] =
  def go(visited: Set[A], u: A): List[List[A]] =
    if isDone(visited, u) then List(List(u))
    else
      val visited1 = visited + u
      expand(visited1, u)
        .flatMap(v => go(visited1, v).map(u :: _))
        .toList
  go(Set.empty, start)
