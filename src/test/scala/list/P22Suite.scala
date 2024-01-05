package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import scala.util.Random
import org.scalacheck.Gen

class P22Suite extends ScalaCheckSuite:

  property("create a list of intergers withhin a given range"):
    forAllNoShrink(Gen.choose(0, 100)) { (end: Int) =>
      val start    = Random.nextInt(end + 1)
      val obtained = P22.range(start, end)
      val expected = (start to end).toList
      assertEquals(obtained, expected)
    }
