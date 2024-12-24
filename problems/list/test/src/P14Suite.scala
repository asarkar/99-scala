package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P14Suite extends ScalaCheckSuite:

  property("duplicate the elements"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val obtained = P14.duplicate(lst)
      val expected = lst.flatMap(n => List.fill(2)(n))
      assertEquals(obtained, expected)
    }
