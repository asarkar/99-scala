package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.*
import P87.nodesByDepthFrom

class P87Spec extends AnyFunSpec:
  it("depth-first order graph traversal"):
    val data = List(
      (
        "[a-b, b-c, e, a-c, a-d]",
        "d",
        Set("c", "b", "a", "d")
      ),
      (
        "[1-2, 2-3, 1-4, 3-4, 5-2, 5-4, 6-7]",
        "1",
        Set("1", "2", "3", "4", "5")
      )
    )

    data.foreach { (s, u, expected) =>
      val g = Graph.fromString(s)
      g.nodesByDepthFrom(u) shouldBe expected
    }
