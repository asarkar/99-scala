package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P05Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("reverse a list"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val obtained = P05.reverse(lst)
      val expected = lst.reverse
      obtained shouldBe expected
    }
