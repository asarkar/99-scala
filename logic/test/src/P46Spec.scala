package logic

import P47.{and, or}

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P46Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("truth table of a given logical expression in two variables"):
    forAll { (x: Boolean, y: Boolean) =>
      val f        = (a: Boolean, b: Boolean) => a and (a or b)
      val obtained = P46.table2(f)
      val expected = List(
        (true, true, true),
        (true, false, true),
        (false, true, false),
        (false, false, false)
      )
      obtained shouldBe expected
    }
