package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P14Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("duplicate the elements"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val obtained = P14.duplicate(lst)
      val expected = lst.flatMap(n => List.fill(2)(n))
      obtained shouldBe expected
    }
