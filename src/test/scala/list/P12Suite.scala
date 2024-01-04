package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P12Suite extends ScalaCheckSuite:

  property("decode run-length encoded list"):
    forAllNoShrink(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.map(x => (x, x))
      val obtained = P12.decode(xs)
      val expected = lst.flatMap(x => List.fill(x)(x))
      assertEquals(obtained, expected)
    }
