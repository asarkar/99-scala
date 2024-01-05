package arithmetic

import munit.FunSuite

class P35Suite extends FunSuite:

  test("determine the prime factors of a given positive integer"):
    val data = List(
      (1, Nil),
      (2, List(2)),
      (9, List(3, 3)),
      (8, List(2, 2, 2)),
      (12, List(2, 2, 3)),
      (315, List(3, 3, 5, 7)),
      (901255, List(5, 17, 23, 461))
    )
    data.foreach { (n, pf) =>
      assertEquals(P35.primeFactors(n), pf)
    }
