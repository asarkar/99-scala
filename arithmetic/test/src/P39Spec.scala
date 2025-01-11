package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P39Spec extends AnyFunSpec:

  it("construct a list of all prime numbers within a given range"):
    val obtained = P39.primesInRng(7, 31)
    val expected = List(7, 11, 13, 17, 19, 23, 29, 31)
    obtained shouldBe expected

    val obtained1 = P39.primesInRng(10, 20)
    val expected1 = List(11, 13, 17, 19)
    obtained1 shouldBe expected1
