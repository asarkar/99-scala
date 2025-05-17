package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.Inspectors.forAll

class P31Spec extends AnyFunSpec:

  it("determine whether a given integer is prime"):
    val data = List(
      (1, false),
      (2, true),
      (3, true),
      (4, false),
      (5, true),
      (6, false),
      (7, true),
      (11, true)
    )
    forAll(data) { (n, prime) =>
      P31.isPrime(n) shouldBe prime
    }
