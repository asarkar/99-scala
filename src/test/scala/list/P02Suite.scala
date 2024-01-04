package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink

class P02Suite extends ScalaCheckSuite:

  property("penultimate element of a non-empty list"):
    forAllNoShrink(ListGen.genSizeBetween(2, 100)) { (lst: List[Int]) =>
      val obtained = P02.penultimate(lst)
      val expected = lst.init.last
      assertEquals(obtained, expected)
    }

  test("penultimate element of an empty list"):
    intercept[NoSuchElementException]:
      P02.penultimate(Nil)

  test("penultimate element of a singleton list"):
    intercept[NoSuchElementException]:
      P02.penultimate(Nil)
