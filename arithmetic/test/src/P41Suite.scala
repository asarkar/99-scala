package arithmetic

import munit.FunSuite

class P41Suite extends FunSuite:

  test("find the Goldbach compositions of all even numbers within a given range"):
    val obtained = P41.goldbachList(9, 20)
    val expected = Map(
      10 -> (3, 7),
      12 -> (5, 7),
      14 -> (3, 11),
      16 -> (3, 13),
      18 -> (5, 13),
      20 -> (3, 17)
    )
    assertEquals(obtained, expected)
