package list

import munit.FunSuite

class P19Suite extends FunSuite:

  test("rotate a list N places to the left"):
    val xs        = ('a' to 'k').toList
    val obtained1 = P19.rotate(3, xs)
    val expected1 = List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c')
    assertEquals(obtained1, expected1)

    val obtained2 = P19.rotate(-2, xs)
    val expected2 = List('j', 'k', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i')
    assertEquals(obtained2, expected2)
