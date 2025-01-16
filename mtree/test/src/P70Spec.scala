package mtree

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P70Spec extends AnyFunSpec:
  val tree = MTree(
    'a',
    List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e'))))
  )
  it("tree construction from a node string"):
    P70.string2MTree("afg^^c^bd^e^^^") shouldBe tree

  it("tree to string"):
    P70.tree2String(tree) shouldBe "afg^^c^bd^e^^^"
