package list

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P19Spec extends AnyFunSpec:

  it("rotate a list N places to the left"):
    val xs        = ('a' to 'k').toList
    val obtained1 = P19.rotate(3, xs)
    val expected1 = List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c')
    obtained1 shouldBe expected1

    val obtained2 = P19.rotate(-2, xs)
    val expected2 = List('j', 'k', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i')
    obtained2 shouldBe expected2
