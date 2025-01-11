package bintree

import scala.language.implicitConversions
import P62B.atLevel

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P62BSpec extends AnyFunSpec:
  it("collect the nodes at a given level in a list"):
    val data: List[(Array[Option[Char]], Int, List[Char])] = List(
      (('a', 'b'), 1, List('a')),
      (('a', 'b', 'c', None, None, 'd', 'e'), 2, List('b', 'c'))
    )
    data.foreach { (xs, level, expected) =>
      val obtained = Tree.fromArray(xs).atLevel(level)
      obtained shouldBe expected
    }
