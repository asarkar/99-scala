package list

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P27Spec extends AnyFunSpec:

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

  it("group the elements of a set into disjoint subsets of 2, 3 and 4 persons"):
    val obtained = P27.group3(people)
    obtained.size shouldBe 1260

  it("group the elements of a set into disjoint subsets"):
    val obtained = P27.group(List(2, 3, 4), people)
    obtained.size shouldBe 1260

    val obtained1 = P27.group(List(2, 2, 5), people)
    obtained1.size shouldBe 756
