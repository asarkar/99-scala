package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink

class P01Suite extends ScalaCheckSuite:

  property("last element of a non-empty list"):
    forAllNoShrink(ListGen.genNotEmpty) { (lst: List[Int]) =>
      val obtained = P01.last(lst)
      val expected = lst.last
      assertEquals(obtained, expected)
    }

  test("last element of an empty list"):
    intercept[NoSuchElementException]:
      P01.last(Nil)
