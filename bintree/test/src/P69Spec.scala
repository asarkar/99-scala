package bintree

import scala.language.implicitConversions
import P69.toDotstring

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P69Spec extends AnyFunSpec:
  it("dotstring representation of binary trees"):
    val tree     = P67.fromString("a(b(d,e),c(,f(g,)))")
    val obtained = tree.toDotstring
    val expected = "abd..e..c.fg..."

    obtained shouldBe expected

    P69.fromDotstring(obtained) shouldBe tree
