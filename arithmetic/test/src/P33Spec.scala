package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P33Spec extends AnyFunSpec:

  it("determine whether two positive integer numbers are coprime"):
    P33.isCoprime(35, 64) shouldBe true
    P33.isCoprime(1173, 1547) shouldBe false
