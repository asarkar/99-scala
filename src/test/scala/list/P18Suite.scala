package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen
import scala.util.Random

class P18Suite extends ScalaCheckSuite:

  property("extract a slice"):
    forAllNoShrink(Gen.listOf(ListGen.genInt)) { (lst: List[Int]) =>
      val end =
        if lst.isEmpty
        then 0
        else Random.between(1, lst.size + 1)
      val start    = if end == 0 then 0 else Random.nextInt(end)
      val obtained = P18.slice(start, end, lst)
      val expected = lst.splitAt(start)._2.take(end - start)
      assertEquals(obtained, expected, s"start=${start}, end=${end}")
    }
