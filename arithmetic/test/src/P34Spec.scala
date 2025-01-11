package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P34Spec extends AnyFunSpec:

  it("calculate Euler's totient function phi"):
    P34.totient(10) shouldBe 4
