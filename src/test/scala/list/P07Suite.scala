package list

import munit.FunSuite

class P07Suite extends FunSuite:

  test("flatten a nested list"):
    val xs       = List(List(1, 1), 2, List(3, List(5, 8)))
    val obtained = P07.flatten(xs)
    val expected = List(1, 1, 2, 3, 5, 8)
    assertEquals(obtained, expected)
