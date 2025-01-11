package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P12Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("decode run-length encoded list"):
    forAll(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.map(x => (x, x))
      val obtained = P12.decode(xs)
      val expected = lst.flatMap(x => List.fill(x)(x))
      obtained shouldBe expected
    }
