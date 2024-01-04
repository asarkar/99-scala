package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import scala.util.Random

class P03Suite extends ScalaCheckSuite:

  property("nth element of a list"):
    forAllNoShrink(ListGen.genNotEmpty) { (lst: List[Int]) =>
      val n        = Random.between(0, lst.size)
      val obtained = P03.nth(n, lst)
      val expected = lst(n)
      assertEquals(obtained, expected)
    }

  test("nth element outside the bounds of a list"):
    intercept[NoSuchElementException]:
      P03.nth(2, List(1))

  test("0th element of an empty list"):
    intercept[NoSuchElementException]:
      P03.nth(0, Nil)
