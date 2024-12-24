package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P25Suite extends ScalaCheckSuite:

  property("generate a random permutation of the elements"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val obtained = P25.randomPermute(lst)
      assert(obtained.sorted == lst.sorted)
    }
