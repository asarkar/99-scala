package list

import org.scalacheck.Gen
import scala.util.Random

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P16Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("drop every Nth element"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val n =
        if lst.isEmpty
        then 0
        else Random.between(1, lst.size + 1)
      val obtained = P16.drop(n, lst)
      // guard in for-comprehension is sugar for withFilter.
      val expected = for ((x, i) <- lst.zipWithIndex if (i + 1) % n != 0) yield x
      obtained shouldBe expected
    }
