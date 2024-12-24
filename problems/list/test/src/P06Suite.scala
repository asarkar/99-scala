package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P06Suite extends ScalaCheckSuite:

  property("check if palindrome"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val xs       = lst ++ lst.reverse
      val obtained = P06.isPalindrome(xs)
      assertEquals(obtained, true)

      assertEquals(P06.isPalindrome(lst), lst == lst.reverse)
    }
