package bintree

import bintree.P56.isSymmetric
import P57.addValue

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P57Spec extends AnyFunSpec:
  it("add an element to a BST"):
    val xs       = List(3, 2, 5, 7, 1)
    val obtained = xs.foldLeft(Tree.empty[Int])((t, x) => t.addValue(x))
    obtained.isSymmetric shouldBe true

    val ys        = List(3, 2, 5, 7, 4)
    val obtained2 = ys.foldLeft(Tree.empty[Int])((t, x) => t.addValue(x))
    obtained2.isSymmetric shouldBe false
