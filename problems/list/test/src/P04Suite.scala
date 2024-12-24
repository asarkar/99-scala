package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P04Suite extends ScalaCheckSuite:

  property("calculate length of a list"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val obtained = P04.length(lst)
      val expected = lst.size
      assertEquals(obtained, expected)
    }
