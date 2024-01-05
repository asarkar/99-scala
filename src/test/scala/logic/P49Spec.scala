package logic

import munit.FunSuite

class P49Spec extends FunSuite:

  test("generate gray codes"):
    val obtained = P49.gray(3)
    val expected = List(
      "000",
      "001",
      "011",
      "010",
      "110",
      "111",
      "101",
      "100"
    )
    assertEquals(obtained, expected)
