package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P09Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("pack consecutive duplicate elements into sublists"):
    forAll(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.flatMap(n => List.fill(n)(n))
      val obtained = P09.pack(xs)
      val expected = xs.foldRight(List.empty[List[Int]])((x, acc) =>
        if (acc.isEmpty || acc.head.head != x)
        then List(x) :: acc
        else (x :: acc.head) :: acc.tail
      )
      obtained shouldBe expected
    }
