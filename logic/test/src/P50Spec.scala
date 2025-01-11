package logic

import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class P50Spec extends AnyFunSpec with ScalaCheckPropertyChecks:

  it("construct Huffman encoding for the given symbols"):
    val freq = List(
      ("a", 45),
      ("b", 13),
      ("c", 12),
      ("d", 16),
      ("e", 9),
      ("f", 5)
    )
    val obtained = P50.huffman(freq)
    val expected = List(
      ("a", "0"),
      ("b", "101"),
      ("c", "100"),
      ("d", "111"),
      ("e", "1101"),
      ("f", "1100")
    )
    obtained.sorted shouldBe expected.sorted
