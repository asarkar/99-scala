package bintree

import munit.FunSuite
import scala.language.implicitConversions
import P69.toDotstring

class P69Suite extends FunSuite:
  test("dotstring representation of binary trees"):
    val tree     = P67.fromString("a(b(d,e),c(,f(g,)))")
    val obtained = tree.toDotstring
    val expected = "abd..e..c.fg..."

    assertEquals(obtained, expected)

    assertEquals(P69.fromDotstring(obtained), tree)
