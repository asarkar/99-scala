package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen
import scala.util.Random

class P15Suite extends ScalaCheckSuite:

  property("duplicate the elements N times"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val n        = Random.between(1, 5)
      val obtained = P15.duplicateN(n, lst)
      val expected = lst.flatMap(x => List.fill(n)(x))
      assertEquals(obtained, expected)
    }
