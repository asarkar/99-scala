package arithmetic

import munit.FunSuite

class P34Suite extends FunSuite:

  test("calculate Euler's totient function phi"):
    assertEquals(P34.totient(10), 4)
