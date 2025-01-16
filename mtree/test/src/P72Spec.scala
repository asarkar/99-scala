package mtree

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import mtree.P72.postorder
import scala.language.implicitConversions

class P72Spec extends AnyFunSpec:
  it("postorder sequence of the tree nodes"):
    "afg^^c^bd^e^^^".postorder shouldBe List('g', 'f', 'c', 'd', 'e', 'b', 'a')
