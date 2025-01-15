package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import P81.findPaths
import scala.math.Ordering.Implicits.seqOrdering

class P81Spec extends AnyFunSpec:
  it("path from one node to another one"):
    val data = List(
      ("[p>q/9, m>q/7, k, p>m/5]", "p", "q", List(List("p", "m", "q"), List("p", "q"))),
      ("[p>q/9, m>q/7, k, p>m/5]", "p", "k", Nil)
    )

    data.foreach { (s, u, v, expected) =>
      val g = Graph.fromString(s)
      g.findPaths(u, v).sorted shouldBe expected
    }
