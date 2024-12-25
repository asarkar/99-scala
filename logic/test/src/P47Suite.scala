package logic

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAll
import P47.*

class P47Suite extends ScalaCheckSuite:

  property("and iff both true"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x and y
      val expected = x && y
      assertEquals(obtained, expected)
    }

  property("or iff any true"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x or y
      val expected = x || y
      assertEquals(obtained, expected)
    }

  property("nand is not and"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x nand y
      val expected = !(x && y)
      assertEquals(obtained, expected)
    }

  property("not is not or"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x nor y
      val expected = !(x || y)
      assertEquals(obtained, expected)
    }

  property("xor iff only one true"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x xor y
      val expected = x ^ y
      assertEquals(obtained, expected)
    }

  property("impl implies consequent is true if antecedent is true"):
    forAll { (x: Boolean) =>
      val obtained = true impl x
      val expected = x
      assertEquals(obtained, expected)
    }

  property("impl does not care if antecedent is false"):
    forAll { (x: Boolean) =>
      val obtained = false impl x
      val expected = true
      assertEquals(obtained, expected)
    }

  property("equ iff the same"):
    forAll { (x: Boolean, y: Boolean) =>
      val obtained = x equ y
      val expected = x == y
      assertEquals(obtained, expected)
    }
