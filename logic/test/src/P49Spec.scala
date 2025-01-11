package logic

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P49Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("generate gray codes"):
    val obtained = P49.gray(3)
    val expected = List(
      "000",
      "001",
      "011",
      "010",
      "110",
      "111",
      "101",
      "100"
    )
    obtained shouldBe expected
