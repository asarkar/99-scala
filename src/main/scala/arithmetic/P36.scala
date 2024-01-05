package arithmetic

// P36 (**) Determine the prime factors of a given positive integer (2).
//     Construct a list containing the prime factors and their multiplicity.
//
//     scala> 315.primeFactorMultiplicity
//     res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
//
//     Alternately, use a Map for the result.
//     scala> 315.primeFactorMultiplicity
//     res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)

object P36:
  def primeFactorMultiplicity(x: Int): Map[Int, Int] =
    P35
      .primeFactors(x)
      .groupBy(identity)
      .map((k, v) => (k, v.length))
