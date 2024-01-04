package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P08Suite extends ScalaCheckSuite:

  property("eliminate consecutive duplicate elements"):
    forAllNoShrink(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.flatMap(n => List.fill(n)(n))
      val obtained = P08.compress(xs)
      val expected = xs.foldRight(List.empty[Int])((x, acc) =>
        if (acc.isEmpty || acc.head != x)
        then x :: acc
        else acc
      )
      assertEquals(obtained, expected)
    }
