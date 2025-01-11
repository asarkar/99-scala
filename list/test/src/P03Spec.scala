package list

import scala.util.Random

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P03Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("nth element of a list"):
    forAll(ListGen.genNotEmpty) { (lst: List[Int]) =>
      val n        = Random.nextInt(lst.size)
      val obtained = P03.nth(n, lst)
      val expected = lst(n)
      obtained shouldBe expected
    }

  it("nth element outside the bounds of a list"):
    intercept[NoSuchElementException]:
      P03.nth(2, List(1))

  it("0th element of an empty list"):
    intercept[NoSuchElementException]:
      P03.nth(0, Nil)
