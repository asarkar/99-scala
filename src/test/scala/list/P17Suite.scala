package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen
import scala.util.Random

class P17Suite extends ScalaCheckSuite:

  property("split a list into two parts"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val n =
        if lst.isEmpty
        then 0
        else Random.between(1, lst.size + 1)
      val obtained = P17.split(n, lst)
      val expected = lst.splitAt(n)
      assertEquals(obtained, expected)
    }
