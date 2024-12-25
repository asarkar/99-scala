package list

import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Gen

class P09Suite extends ScalaCheckSuite:

  property("pack consecutive duplicate elements into sublists"):
    forAllNoShrink(Gen.listOf(Gen.choose(1, 5))) { (lst: List[Int]) =>
      val xs       = lst.flatMap(n => List.fill(n)(n))
      val obtained = P09.pack(xs)
      val expected = xs.foldRight(List.empty[List[Int]])((x, acc) =>
        if (acc.isEmpty || acc.head.head != x)
        then List(x) :: acc
        else (x :: acc.head) :: acc.tail
      )
      assertEquals(obtained, expected)
    }
