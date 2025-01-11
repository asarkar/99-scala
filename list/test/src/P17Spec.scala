package list

import org.scalacheck.Gen
import scala.util.Random

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P17Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("split a list into two parts"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val n =
        if lst.isEmpty
        then 0
        else Random.between(1, lst.size + 1)
      val obtained = P17.split(n, lst)
      val expected = lst.splitAt(n)
      obtained shouldBe expected
    }
