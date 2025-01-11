package list

import scala.util.Random
import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P24Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("draw N different random numbers from the set 1..M"):
    forAll(Gen.choose(1, 100)) { (m: Int) =>
      val n        = Random.nextInt(m + 1)
      val obtained = P24.lotto(n, m)
      obtained.size shouldBe n
      obtained.forall(x => (1 to m).exists(_ == x)) shouldBe true
    }
