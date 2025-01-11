package arithmetic

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P41Spec extends AnyFunSpec:

  it("find the Goldbach compositions of all even numbers within a given range"):
    val obtained = P41.goldbachList(9, 20)
    val expected = Map(
      10 -> (3, 7),
      12 -> (5, 7),
      14 -> (3, 11),
      16 -> (3, 13),
      18 -> (5, 13),
      20 -> (3, 17)
    )
    obtained shouldBe expected
