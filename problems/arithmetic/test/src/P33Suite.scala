package arithmetic

import munit.FunSuite

class P33Suite extends FunSuite:

  test("determine whether two positive integer numbers are coprime"):
    assertEquals(P33.isCoprime(35, 64), true)
    assertEquals(P33.isCoprime(1173, 1547), false)
