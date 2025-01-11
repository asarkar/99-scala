package list

import scala.util.Random

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P20Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("remove the Kth element"):
    forAll(ListGen.genNotEmpty) { (lst: List[Int]) =>
      val k             = Random.nextInt(lst.size)
      val obtained      = P20.removeAt(k, lst)
      val (left, right) = lst.splitAt(k)
      val expected      = (left ++ right.tail, right.head)
      obtained shouldBe expected
    }
