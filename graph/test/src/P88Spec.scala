package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.*
import P88.splitGraph
import org.scalatest.Inspectors.forAll

class P88Spec extends AnyFunSpec:
  it("connected components"):
    val data = List(
      (
        "[a-b, c]",
        Set(Set("a", "b"), Set("c"))
      )
    )

    forAll(data) { (s, expected) =>
      val g = Graph.fromString(s)
      g.splitGraph shouldBe expected
    }
