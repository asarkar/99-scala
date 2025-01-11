package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P36Spec extends AnyFunSpec:

  it("construct a list containing the prime factors and their multiplicity for a given integer"):
    P36.primeFactorMultiplicity(315) shouldBe Map(3 -> 2, 5 -> 1, 7 -> 1)
