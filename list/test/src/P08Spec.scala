package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P08Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("eliminate consecutive duplicate elements"):
    forAll(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.flatMap(n => List.fill(n)(n))
      val obtained = P08.compress(xs)
      val expected = xs.foldRight(List.empty[Int])((x, acc) =>
        if (acc.isEmpty || acc.head != x)
        then x :: acc
        else acc
      )
      obtained shouldBe expected
    }
