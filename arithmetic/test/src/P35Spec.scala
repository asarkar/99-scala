package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.Inspectors.forAll

class P35Spec extends AnyFunSpec:

  it("determine the prime factors of a given positive integer"):
    val data = List(
      (1, Nil),
      (2, List(2)),
      (9, List(3, 3)),
      (8, List(2, 2, 2)),
      (12, List(2, 2, 3)),
      (315, List(3, 3, 5, 7)),
      (901255, List(5, 17, 23, 461))
    )
    forAll(data) { (n, pf) =>
      P35.primeFactors(n) shouldBe pf
    }
