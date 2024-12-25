package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P10Suite extends ScalaCheckSuite:

  property("run-length encoding"):
    forAllNoShrink(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.flatMap(n => List.fill(n)(n))
      val obtained = P10.encode(xs)
      val expected = xs.foldRight(List.empty[(Int, Int)])((x, acc) =>
        if (acc.isEmpty || acc.head(1) != x)
        then (1, x) :: acc
        else (acc.head(0) + 1, acc.head(1)) :: acc.tail
      )
      assertEquals(obtained, expected)
    }
