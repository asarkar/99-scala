package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P13Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("run-length encoding direct"):
    forAll(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.flatMap(n => List.fill(n)(n))
      val obtained = P13.encodeDirect(xs)
      val expected = P10.encode(xs)
      obtained shouldBe expected
    }
