package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P05Suite extends ScalaCheckSuite:

  property("reverse a list"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val obtained = P05.reverse(lst)
      val expected = lst.reverse
      assertEquals(obtained, expected)
    }
