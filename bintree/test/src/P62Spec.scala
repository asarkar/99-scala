package bintree

import scala.language.implicitConversions
import P62.internalList

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P62Spec extends AnyFunSpec:
  it("collect the internal nodes of a binary tree in a list"):
    val data: List[(Array[Option[Char]], List[Char])] = List(
      (('a', 'b'), List('a')),
      (('a', 'b', 'c', None, None, 'd', 'e'), List('a', 'c'))
    )
    data.foreach { (xs, expected) =>
      val obtained = Tree.fromArray(xs).internalList
      obtained shouldBe expected
    }
