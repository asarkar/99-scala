package list

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P02Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("penultimate element of a non-empty list"):
    forAll(ListGen.genSizeBetween(2, 100)) { (lst: List[Int]) =>
      val obtained = P02.penultimate(lst)
      val expected = lst.init.last
      obtained shouldBe expected
    }

  it("penultimate element of an empty list"):
    intercept[NoSuchElementException]:
      P02.penultimate(Nil)

  it("penultimate element of a singleton list"):
    intercept[NoSuchElementException]:
      P02.penultimate(Nil)
