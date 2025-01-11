package list

import org.scalacheck.Gen

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P11Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("modified run-length encoding"):
    forAll(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.flatMap(n => List.fill(n)(n))
      val obtained = P11.encodeModified(xs)
      val expected = xs
        .foldRight(List.empty[(Int, Int)])((x, acc) =>
          if (acc.isEmpty || acc.head(1) != x)
          then (1, x) :: acc
          else (acc.head(0) + 1, acc.head(1)) :: acc.tail
        )
        .map((len, x) => if len == 1 then x else (len, x))
      obtained shouldBe expected
    }
