package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import scala.util.Random

class P20Suite extends ScalaCheckSuite:

  property("remove the Kth element"):
    forAllNoShrink(ListGen.genNotEmpty) { (lst: List[Int]) =>
      val k             = Random.between(0, lst.size)
      val obtained      = P20.removeAt(k, lst)
      val (left, right) = lst.splitAt(k)
      val expected      = (left ++ right.tail, right.head)
      assertEquals(obtained, expected, s"k=${k}")
    }
