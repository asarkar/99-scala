package list

import scala.util.Random
import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P21Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("insert an element at a given position"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val k             = Random.nextInt(lst.size + 1)
      val obtained      = P21.insertAt(k, k, lst)
      val (left, right) = lst.splitAt(k)
      val expected      = left ++ (k :: right)
      obtained shouldBe expected
    }
