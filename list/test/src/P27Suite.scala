package list

import munit.FunSuite

class P27Suite extends FunSuite:

  val people = List(
    "aldo",
    "beat",
    "carla",
    "david",
    "evi",
    "flip",
    "gary",
    "hugo",
    "ida"
  )

  test("group the elements of a set into disjoint subsets of 2, 3 and 4 persons"):
    val obtained = P27.group3(people)
    assertEquals(obtained.size, 1260)

  test("group the elements of a set into disjoint subsets"):
    val obtained = P27.group(List(2, 3, 4), people)
    assertEquals(obtained.size, 1260)

    val obtained1 = P27.group(List(2, 2, 5), people)
    assertEquals(obtained1.size, 756)
