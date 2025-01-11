package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P06Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("check if palindrome"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val xs       = lst ++ lst.reverse
      val obtained = P06.isPalindrome(xs)
      obtained shouldBe true

      P06.isPalindrome(lst) shouldBe lst == lst.reverse
    }
