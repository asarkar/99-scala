package arithmetic

import munit.FunSuite

class P32Suite extends FunSuite:

  test("determine the greatest common divisor of two positive integers"):
    assertEquals(P32.gcd(36, 63), 9)
    assertEquals(P32.gcd(63, 36), 9)
    assertEquals(P32.gcd(125, 81), 1)
    assertEquals(P32.gcd(221, 559), 13)
