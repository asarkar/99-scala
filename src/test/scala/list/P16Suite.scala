package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen
import scala.util.Random

class P16Suite extends ScalaCheckSuite:

  property("drop every Nth element"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val n =
        if lst.isEmpty
        then 0
        else Random.between(1, lst.size + 1)
      val obtained = P16.drop(n, lst)
      // guard in for-comprehension is sugar for withFilter.
      val expected = for ((x, i) <- lst.zipWithIndex if (i + 1) % n != 0) yield x
      assertEquals(obtained, expected)
    }
