package misc

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.{contain, should}
import org.scalatest.Inspectors.forAll

class P91Spec extends AnyFunSpec:

  it("knights tours"):
    forAll(P91.allKnightsTours(8).take(2)) { tour =>
      tour should contain theSameElementsAs P91.allSquares(8).toList
    }
