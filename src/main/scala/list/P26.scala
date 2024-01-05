package list

// P26 (**) Generate the combinations of K distinct objects chosen from the N
//          elements of a list.
//     In how many ways can a committee of 3 be chosen from a group of 12
//     people?  We all know that there are C(12,3) = 220 possibilities (C(N,K)
//     denotes the well-known binomial coefficient).  For pure mathematicians,
//     this result may be great.  But we want to really generate all the possibilities.
//
//     Example:
//     scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
//     res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

object P26:
  def combinations[A](n: Int, l: List[A]): List[List[A]] =
    if n == 0
    then Nil
    else
      (
        for
          xs <- l.tails if xs.nonEmpty
          // In Haskell we can pattern match (x : xs) <- tails l, and
          // if xxs is empty, that iteration is discarded.
          // Here, we have to use a guard condition.
          // Also, in Haskell, xs <- [] is [], so, appending to it works in
          // the return, but here, we have to create a List containing a Nil,
          // otherwise yield return Nil.
          ys <- if n == 1 then List(Nil) else combinations(n - 1, xs.tail)
        yield xs.head :: ys
      ).toList
