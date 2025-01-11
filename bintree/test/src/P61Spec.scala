package bintree

import scala.language.implicitConversions
import P61.leafCount

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P61Spec extends AnyFunSpec:
  it("count the leaves of a binary tree"):
    val data: List[(Array[Option[Char]], Int)] = List(
      (('x', 'x'), 1),
      (('a', 'b', 'c', None, None, 'd', 'e'), 3)
    )

    data.foreach { (xs, expected) =>
      val obtained = Tree.fromArray(xs).leafCount
      obtained shouldBe expected
    }
