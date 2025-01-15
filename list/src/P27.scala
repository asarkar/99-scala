package list

// P27 (**) Group the elements of a set into disjoint subsets.
// a) In how many ways can a group of 9 people work in 3 disjoint subgroups
//    of 2, 3 and 4 persons?  Write a function that generates all the
//    possibilities.
//
//    scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
//    res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
//
// b) Generalize the above predicate in a way that we can specify a list
//    of group sizes and the predicate will return a list of groups.
//
//    scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
//    res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...
//
// Note that we do not want permutations of the group members;
// i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...).
// However, we make a difference between ((Aldo, Beat), (Carla, David), ...)
// and ((Carla, David), (Aldo, Beat), ...).
//
// You may find more about this combinatorial problem in a good book on
// discrete mathematics under the term "multinomial coefficients".

object P27:
  def group3[A](l: List[A]): List[List[List[A]]] =
    group(List(2, 3, 4), l)

  def group[A](ns: List[Int], l: List[A]): List[List[List[A]]] =
    ns match
      case _ :: Nil => List(List(l))
      case Nil      => ???
      case n :: next =>
        for
          xs  <- P26.combinations(n, l)
          xxs <- group(next, l.filterNot(xs.contains))
        yield xs :: xxs
