package misc

import misc.P92.Edge
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.{all, be, have, should, shouldBe}
import org.scalatest.Inspectors.forAll

class P92Spec extends AnyFunSpec:

  it("von koch's conjecture"):
    val data: List[Set[Edge]] = List(
      Set(
        (1, 6),
        (2, 6),
        (3, 6),
        (4, 6),
        (5, 6),
        (5, 7),
        (5, 8),
        (8, 9),
        (5, 10),
        (10, 11),
        (11, 12),
        (11, 13),
        (13, 14)
      ),
      Set((1, 7), (7, 2), (7, 3), (3, 5), (3, 6), (5, 4))
    )
    forAll(data) { edges =>
      val labeling = P92.vonKochLabeling(edges)
      val vertices = edges.flatMap(e => Set(e.u, e.v))
      labeling.keySet shouldBe vertices
      val labels = labeling.values.toSet
      labels should have size vertices.size
      all(labels) should (be >= 1 and be <= vertices.size)
    }
