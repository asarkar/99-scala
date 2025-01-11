package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P25Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("generate a random permutation of the elements"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val obtained = P25.randomPermute(lst)
      obtained.sorted shouldBe lst.sorted
    }
