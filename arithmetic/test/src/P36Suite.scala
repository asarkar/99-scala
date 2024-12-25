package arithmetic

import munit.FunSuite

class P36Suite extends FunSuite:

  test("construct a list containing the prime factors and their multiplicity for a given integer"):
    assertEquals(P36.primeFactorMultiplicity(315), Map(3 -> 2, 5 -> 1, 7 -> 1))
