package list

import org.scalacheck.Gen
import scala.util.Random

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P18Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("extract a slice"):
    forAll(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val end =
        if lst.isEmpty
        then 0
        else Random.between(1, lst.size + 1)
      val start    = if end == 0 then 0 else Random.nextInt(end)
      val obtained = P18.slice(start, end, lst)
      val expected = lst.splitAt(start)._2.take(end - start)
      obtained shouldBe expected
    }
