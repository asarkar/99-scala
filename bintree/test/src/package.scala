package bintree

import munit.Assertions.{assert, assertEquals}

given [A] => Conversion[Tuple, Array[Option[A]]] = nums =>
  nums.toArray.map:
    case None => None
    case x => Some(x.asInstanceOf[A])

def assertSameTrees[A](trees: List[Tree[A]], expected: List[Array[Option[A]]]): Unit =
  assertEquals(trees.size, expected.size)
  assert(trees.forall(expected.map(Tree.fromArray).contains))
            
