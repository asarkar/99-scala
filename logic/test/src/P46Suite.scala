package logic

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAll
import P47.{and, or}

class P46Suite extends ScalaCheckSuite:

  property("truth table of a given logical expression in two variables"):
    forAll { (x: Boolean, y: Boolean) =>
      val f        = (a: Boolean, b: Boolean) => a and (a or b)
      val obtained = P46.table2(f)
      val expected = List(
        (true, true, true),
        (true, false, true),
        (false, true, false),
        (false, false, false)
      )
      assertEquals(obtained, expected)
    }
