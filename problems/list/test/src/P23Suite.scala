package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import scala.util.Random
import org.scalacheck.Gen

class P23Suite extends ScalaCheckSuite:

  property("extract a given number of randomly selected elements"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val k        = lst.size
      val n        = Random.nextInt(k + 1)
      val obtained = P23.randomSelect(n, lst)
      assert(obtained.size == n && obtained.forall(lst.contains))
    }

  property("extract n random elements from a list where n >>> list.size"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val k        = lst.size
      val obtained = P23.randomSelect(Int.MaxValue, lst)
      assert(obtained.size == k && obtained.forall(lst.contains))
    }
