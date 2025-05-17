package bintree

import org.scalatest.Inspectors.forAll

import scala.language.implicitConversions
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P59Spec extends AnyFunSpec:
  it("construct height-balanced binary trees"):
    val obtained = P59.hbalTrees(3, 'x')
    val expected: List[Array[Option[Char]]] = List(
      ('x', 'x', 'x', None, None, None, 'x'),
      ('x', 'x', 'x', None, None, 'x'),
      ('x', 'x', 'x', None, None, 'x', 'x'),
      ('x', 'x', 'x', None, 'x')
    )
    forAll(expected) { xs =>
      obtained.contains(Tree.fromArray(xs)) shouldBe true
    }
