package list

import munit.FunSuite

class P26Suite extends FunSuite:

  test("generate K-combinations"):
    val obtained = P26.combinations(3, List('a', 'b', 'c', 'd', 'e', 'f'))
    val expected = List(
      List('a', 'b', 'c'),
      List('a', 'b', 'd'),
      List('a', 'b', 'e'),
      List('a', 'b', 'f'),
      List('a', 'c', 'd'),
      List('a', 'c', 'e'),
      List('a', 'c', 'f'),
      List('a', 'd', 'e'),
      List('a', 'd', 'f'),
      List('a', 'e', 'f'),
      List('b', 'c', 'd'),
      List('b', 'c', 'e'),
      List('b', 'c', 'f'),
      List('b', 'd', 'e'),
      List('b', 'd', 'f'),
      List('b', 'e', 'f'),
      List('c', 'd', 'e'),
      List('c', 'd', 'f'),
      List('c', 'e', 'f'),
      List('d', 'e', 'f')
    )
    assertEquals(obtained, expected)

    assertEquals(Nil, Nil)
