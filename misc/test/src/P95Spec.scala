package misc

import misc.P95
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P95Spec extends AnyFunSpec:

  it("english number words"):
    P95.fullWords(175) shouldBe "one-seven-five"
    P95.fullWords(0) shouldBe "zero"
    P95.fullWords(1) shouldBe "one"
