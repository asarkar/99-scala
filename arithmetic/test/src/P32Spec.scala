package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P32Spec extends AnyFunSpec:

  it("determine the greatest common divisor of two positive integers"):
    P32.gcd(36, 63) shouldBe 9
    P32.gcd(63, 36) shouldBe 9
    P32.gcd(125, 81) shouldBe 1
    P32.gcd(221, 559) shouldBe 13
