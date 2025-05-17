package bintree

import org.scalatest.Inspectors.forAll

import scala.language.implicitConversions
import org.scalatest.funspec.AnyFunSpec

class P55Spec extends AnyFunSpec:
  it("construct completely balanced binary trees"):
    val data: List[(Int, List[Array[Option[Char]]])] = List(
      (0, List()),
      (1, List(Tuple('x'))),
      (2, List(('x', 'x', None), ('x', None, 'x'))),
      (3, (List(('x', 'x', 'x')))),
      (
        4,
        List(
          ('x', 'x', 'x', 'x'),
          ('x', 'x', 'x', None, 'x'),
          ('x', 'x', 'x', None, None, 'x'),
          ('x', 'x', 'x', None, None, None, 'x')
        )
      )
    )
    forAll(data) { (n, expected) =>
      val obtained = P55.cBalanced(n, 'x')
      assertSameTrees(obtained, expected)
    }
