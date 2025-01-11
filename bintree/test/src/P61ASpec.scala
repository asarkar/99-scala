package bintree

import scala.language.implicitConversions
import P61A.leafList

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P61ASpec extends AnyFunSpec:
  it("collect the leaves of a binary tree in a list"):
    val data: List[(Array[Option[Char]], List[Char])] = List(
      (('x', 'x'), List('x')),
      (('a', 'b', 'c', None, None, 'd', 'e'), List('b', 'd', 'e'))
    )
    data.foreach { (xs, expected) =>
      val obtained = Tree.fromArray(xs).leafList
      obtained shouldBe expected
    }
