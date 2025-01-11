package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P04Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("calculate length of a list"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val obtained = P04.length(lst)
      val expected = lst.size
      obtained shouldBe expected
    }
