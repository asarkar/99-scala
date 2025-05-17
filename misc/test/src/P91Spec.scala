package misc

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.{contain, should, have}
import org.scalatest.Inspectors.forAll

class P91Spec extends AnyFunSpec:

  it("knights tours"):
    forAll(List(5, 8)) { n =>
      val squares = P91.allSquares(n).toList
      squares should have `size` (n * n)
      forAll(P91.allKnightsTours(n).take(5)) { tour =>
        tour should contain theSameElementsAs squares
      }
    }
