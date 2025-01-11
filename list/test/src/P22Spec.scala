package list

import scala.util.Random
import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P22Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("create a list of intergers withhin a given range"):
    forAll(Gen.choose(0, 100)) { (end: Int) =>
      val start    = Random.nextInt(end + 1)
      val obtained = P22.range(start, end)
      val expected = (start to end).toList
      obtained shouldBe expected
    }
