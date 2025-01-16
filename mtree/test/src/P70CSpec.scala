package mtree

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import P70C.nodeCount

class P70CSpec extends AnyFunSpec:
  it("count the nodes of a multiway tree"):
    MTree('a', List(MTree('f'))).nodeCount shouldBe 2
