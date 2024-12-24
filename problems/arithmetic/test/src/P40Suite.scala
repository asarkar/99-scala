package arithmetic

import munit.FunSuite

class P40Suite extends FunSuite:

  test("find the two prime numbers that sum up to a given even integer"):
    val obtained = P40.goldbach(28)
    val expected = (5, 23)
    assertEquals(obtained, expected)
