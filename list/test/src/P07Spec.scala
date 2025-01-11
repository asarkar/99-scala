package list

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P07Spec extends AnyFunSpec:

  it("flatten a nested list"):
    val xs       = List(List(1, 1), 2, List(3, List(5, 8)))
    val obtained = P07.flatten(xs)
    val expected = List(1, 1, 2, 3, 5, 8)
    obtained shouldBe expected
