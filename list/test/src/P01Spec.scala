package list

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P01Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("last element of a non-empty list"):
    forAll(ListGen.genNotEmpty) { (lst: List[Int]) =>
      val obtained = P01.last(lst)
      val expected = lst.last
      obtained shouldBe expected
    }

  it("last element of an empty list"):
    intercept[NoSuchElementException]:
      P01.last(Nil)
