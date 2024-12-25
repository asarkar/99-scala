package bintree

import munit.FunSuite

class P63Suite extends FunSuite:
  test("level order"):
    val data: List[Int] = List(
      6
    )
    data.foreach { n =>
      val obtained = P63.completeBinaryTree(n, "x")
      assertEquals(obtained.levelOrder, List.fill(n)(Some("x")))
    }
