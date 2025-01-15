package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.*
import P89.isBipartite

class P89Spec extends AnyFunSpec:
  it("bipartite graphs"):
    val data = List(
      ("[a>b, c>a, d>b]", true),
      ("[a-b, b-c, c-a]", false),
      ("[a-b, b-c, d]", true),
      ("[a-b, b-c, d, e-f, f-g, g-e, h]", false)
    )

    data.foreach { (s, expected) =>
      val g = if s.contains(">") then Graph.fromStringLabel(s) else Graph.fromString(s)
      g.isBipartite shouldBe expected
    }
