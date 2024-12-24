package arithmetic

import munit.FunSuite

class P39Suite extends FunSuite:

  test("construct a list of all prime numbers within a given range"):
    val obtained = P39.primesInRng(7, 31)
    val expected = List(7, 11, 13, 17, 19, 23, 29, 31)
    assertEquals(obtained, expected)

    val obtained1 = P39.primesInRng(10, 20)
    val expected1 = List(11, 13, 17, 19)
    assertEquals(obtained1, expected1)
