package list

import munit.FunSuite

class P28Suite extends FunSuite:

  val lst = List(
    List('a', 'b', 'c'),
    List('d', 'e'),
    List('f', 'g', 'h'),
    List('d', 'e'),
    List('i', 'j', 'k', 'l'),
    List('m', 'n'),
    List('o')
  )

  test("sort a list of lists according to the length of sublists"):
    val obtained = P28.lsort(lst)
    val expected = List(
      List('o'),
      List('d', 'e'),
      List('d', 'e'),
      List('m', 'n'),
      List('a', 'b', 'c'),
      List('f', 'g', 'h'),
      List('i', 'j', 'k', 'l')
    )
    assertEquals(obtained, expected)

  test("sort a list of lists according to the length frequency of sublists"):
    val obtained = P28.lsortFreq(lst)
    val expected = List(
      List('i', 'j', 'k', 'l'),
      List('o'),
      List('a', 'b', 'c'),
      List('f', 'g', 'h'),
      List('d', 'e'),
      List('d', 'e'),
      List('m', 'n')
    )
    assertEquals(obtained, expected)
