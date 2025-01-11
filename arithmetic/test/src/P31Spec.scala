package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

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
    data.foreach { (n, prime) =>
      P31.isPrime(n) shouldBe prime
    }
