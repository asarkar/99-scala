package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import scala.util.Random
import org.scalacheck.Gen

class P21Suite extends ScalaCheckSuite:

  property("insert an element at a given position"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val k             = Random.nextInt(lst.size + 1)
      val obtained      = P21.insertAt(k, k, lst)
      val (left, right) = lst.splitAt(k)
      val expected      = left ++ (k :: right)
      assertEquals(obtained, expected, s"k=${k}")
    }
