package mtree

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import mtree.P71.internalPathLength
import scala.language.implicitConversions

class P71Spec extends AnyFunSpec:
  it("internal path length of a tree"):
    "afg^^c^bd^e^^^".internalPathLength shouldBe 9
