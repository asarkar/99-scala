package arithmetic

import math.Integral.Implicits.infixIntegralOps

// P39 (*) A list of prime numbers.
// Given a range of integers by its lower and upper limit, construct a list
// of all prime numbers in that range.
//
// scala> listPrimesinRange(7 to 31)
// res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

object P39:
  def primesInRng(a: Int, b: Int): List[Int] =
    val o = 3.max(a + (if a % 2 == 0 then 1 else 0))
    val r = Math.sqrt(b.toDouble + 1).toInt
    val composites =
      (for
        p <- (3 to r by 2)
        q      = p * p
        s      = 2 * p
        (n, x) = (o - q) /% s
        q2 =
          if o <= q
          then q
          else q + (n + x.sign) * s
        i <- q2 to b by s
      yield i).toSet

    val xs = (o to b by 2).filterNot(composites.contains).toList
    if a < 3
    then 2 :: xs
    else xs
