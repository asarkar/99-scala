package mtree

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import mtree.P73.lispyTree
import org.scalatest.Inspectors.forAll

import scala.language.implicitConversions

class P73Spec extends AnyFunSpec:
  it("lisp-like tree representation"):
    val data = List(
      ("a^", "a"),
      ("ab^^", "(a b)"),
      ("abc^^^", "(a (b c))"),
      ("bd^e^^", "(b d e)"),
      ("afg^^c^bd^e^^^", "(a (f g) c (b d e))")
    )

    forAll(data) { (s, expected) =>
      s.lispyTree shouldBe expected
      P73.lispyString2Tree(expected) shouldBe P70.string2MTree(s)
    }
