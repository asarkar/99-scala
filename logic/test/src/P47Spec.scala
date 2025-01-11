package logic

import P47.*

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P47Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("and iff both true"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x and y
      val expected = x && y
      obtained shouldBe expected
    }

  it("or iff any true"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x or y
      val expected = x || y
      obtained shouldBe expected
    }

  it("nand is not and"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x nand y
      val expected = !(x && y)
      obtained shouldBe expected
    }

  it("not is not or"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x nor y
      val expected = !(x || y)
      obtained shouldBe expected
    }

  it("xor iff only one true"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x xor y
      val expected = x ^ y
      obtained shouldBe expected
    }

  it("impl implies consequent is true if antecedent is true"):
    forAll { (x: Boolean) =>
      val obtained = true impl x
      val expected = x
      obtained shouldBe expected
    }

  it("impl does not care if antecedent is false"):
    forAll { (x: Boolean) =>
      val obtained = false impl x
      val expected = true
      obtained shouldBe expected
    }

  it("equ iff the same"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x equ y
      val expected = x == y
      obtained shouldBe expected
    }
