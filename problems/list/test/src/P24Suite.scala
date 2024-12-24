package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import scala.util.Random
import org.scalacheck.Gen

class P24Suite extends ScalaCheckSuite:

  property("draw N different random numbers from the set 1..M"):
    forAllNoShrink(Gen.choose(1, 100)) { (m: Int) =>
      val n        = Random.nextInt(m + 1)
      val obtained = P24.lotto(n, m)
      assert(obtained.size == n && obtained.forall(x => (1 to m).exists(_ == x)))
    }
