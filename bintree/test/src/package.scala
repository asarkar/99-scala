package bintree

import org.scalatest.matchers.should.Matchers.shouldBe

given [A] => Conversion[Tuple, Array[Option[A]]] = nums =>
  nums.toArray.map:
    case None => None
    case x    => Some(x.asInstanceOf[A])

def assertSameTrees[A](trees: List[Tree[A]], expected: List[Array[Option[A]]]): Unit =
  trees.size shouldBe expected.size
  trees.forall(expected.map(Tree.fromArray).contains) shouldBe true
