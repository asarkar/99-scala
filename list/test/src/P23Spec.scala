package list

import scala.util.Random
import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P23Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("extract a given number of randomly selected elements"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val k        = lst.size
      val n        = Random.nextInt(k + 1)
      val obtained = P23.randomSelect(n, lst)
      obtained.size shouldBe n
      obtained.forall(lst.contains) shouldBe true
    }

  it("extract n random elements from a list where n >>> list.size"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val k        = lst.size
      val obtained = P23.randomSelect(Int.MaxValue, lst)
      obtained.size shouldBe k
      obtained.forall(lst.contains) shouldBe true
    }
