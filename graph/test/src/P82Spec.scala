package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import P82.findCycles
import org.scalatest.Inspectors.forAll

import scala.math.Ordering.Implicits.seqOrdering

class P82Spec extends AnyFunSpec:
  it("cycle from a given node"):
    val data = List(
      (
        "[b-c, f-c, g-h, d, f-b, k-f, h-g]",
        "f",
        List(List("f", "b", "c", "f"), List("f", "c", "b", "f"))
      )
    )

    forAll(data) { (s, u, expected) =>
      val g = Graph.fromString(s)
      g.findCycles(u).sorted shouldBe expected
    }
