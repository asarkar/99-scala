package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P13Suite extends ScalaCheckSuite:

  property("run-length encoding direct"):
    forAllNoShrink(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.flatMap(n => List.fill(n)(n))
      val obtained = P13.encodeDirect(xs)
      val expected = P10.encode(xs)
      assertEquals(obtained, expected)
    }
