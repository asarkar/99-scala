package bintree

import org.scalatest.Inspectors.forAll

import scala.language.implicitConversions
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class TreeSpec extends AnyFunSpec:
  it("toString"):
    val nums: Array[Option[Int]] = ('a', 'b', 'c', 'd', 'e', None, 'f', None, None, None, None, 'g')
    val expected                 = "T(a T(b T(d . .) T(e . .)) T(c . T(f T(g . .) .)))"
    Tree.fromArray(nums).toString() shouldBe expected

  it("level order"):
    val data: List[Array[Option[Int]]] = List(
      Tuple(),
      Tuple(1),
      (1, 2),
      (1, 2, 3),
      (1, None, 2),
      (1, 2, None, 3),
      (4, 2, 5, 1, 3),
      (3, 1, 4, None, 2),
      (1, 3, 2, 5, 3, None, 9),
      (10, 5, 15, 3, 7, None, 18),
      (7, 3, 15, None, None, 9, 20),
      (1, 2, 3, None, None, 4, 5, 6, 7),
      (10, 5, 15, 3, 7, 13, 18, 1, None, 6),
      (3, 5, 1, 6, 2, 0, 8, None, None, 7, 4)
    )
    forAll(data) { nums =>
      val tree     = Tree.fromArray(nums)
      val obtained = tree.levelOrder.toArray
      val result = nums
        .zipAll(obtained, None, None)
        .forall:
          case (None, None)       => true
          case (Some(x), Some(y)) => x == y
          case _                  => false

      result shouldBe true
    }

    // format: off
    val xs: Array[Option[Char]] = (
      'n', 'k', 'u', 'c', 'm', 'p', None,
      'a', 'h', None, None, None, 's',
      None, None, 'g', None, 'q', None, 'e'
    )
    // format: on
    val tree = Tree.fromArray(xs).levelOrder.toArray
    val result = xs
      .zipAll(tree, None, None)
      .forall:
        case (None, None)       => true
        case (Some(x), Some(y)) => x == y
        case _                  => false

    result shouldBe true
