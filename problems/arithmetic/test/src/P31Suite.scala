package arithmetic

import munit.FunSuite

class P31Suite extends FunSuite:

  test("determine whether a given integer is prime"):
    val data = List(
      (1, false),
      (2, true),
      (3, true),
      (4, false),
      (5, true),
      (6, false),
      (7, true),
      (11, true)
    )
    data.foreach { (n, prime) =>
      assertEquals(P31.isPrime(n), prime, s"n=${n}")
    }
