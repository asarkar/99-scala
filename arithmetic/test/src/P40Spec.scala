package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P40Spec extends AnyFunSpec:

  it("find the two prime numbers that sum up to a given even integer"):
    val obtained = P40.goldbach(28)
    val expected = (5, 23)
    obtained shouldBe expected
