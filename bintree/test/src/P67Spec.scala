package bintree

import org.scalatest.Inspectors.forAll

import scala.language.implicitConversions
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P67Spec extends AnyFunSpec:
  it("string representation of binary trees"):
    val data: List[Array[Option[Char]]] = List(
      Tuple(),
      Tuple('1'),
      ('1', '2'),
      ('1', '2', '3'),
      ('1', None, '2'),
      ('1', '2', None, '3'),
      ('4', '2', '5', '1', '3'),
      ('3', '1', '4', None, '2'),
      ('1', '3', '2', '5', '3', None, '9'),
      ('1', '2', '3', None, None, '4', '5', '6', '7'),
      ('3', '5', '1', '6', '2', '0', '8', None, None, '7', '4'),
      ('a', 'b', 'c', 'd', 'e', None, 'f', None, None, None, None, 'g')
    )

    forAll(data) { xs =>
      val tree     = Tree.fromArray(xs)
      val s        = P67.toString(tree)
      val obtained = P67.fromString(s)
      obtained shouldBe tree
    }
