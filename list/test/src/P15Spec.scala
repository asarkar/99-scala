package list

import org.scalacheck.Gen
import scala.util.Random

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P15Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("duplicate the elements N times"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val n        = Random.between(1, 5)
      val obtained = P15.duplicateN(n, lst)
      val expected = lst.flatMap(x => List.fill(n)(x))
      obtained shouldBe expected
    }
