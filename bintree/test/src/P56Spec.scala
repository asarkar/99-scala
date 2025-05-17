package bintree

import scala.language.implicitConversions
import bintree.P56.isSymmetric
import org.scalatest.Inspectors.forAll
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P56Spec extends AnyFunSpec:
  it("check whether a given binary tree is symmetric"):
    val data: List[(Boolean, Array[Option[Char]])] = List(
      (false, ('a', 'b')),
      (true, ('a', 'b', 'c'))
    )

    forAll(data) { (symmetric, xs) =>
      val tree = Tree.fromArray(xs)
      tree.isSymmetric shouldBe symmetric
    }
