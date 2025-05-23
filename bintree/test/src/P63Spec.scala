package bintree

import org.scalatest.Inspectors.forAll
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P63Spec extends AnyFunSpec:
  it("level order"):
    val data: List[Int] = List(
      6
    )
    forAll(data) { n =>
      val obtained = P63.completeBinaryTree(n, "x")
      obtained.levelOrder shouldBe List.fill(n)(Some("x"))
    }
