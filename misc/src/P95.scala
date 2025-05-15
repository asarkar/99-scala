package misc
import math.Integral.Implicits.infixIntegralOps

// P95 (**) English number words.
// On financial documents, like checks, numbers must sometimes be written in full words.
// Example: 175 must be written as one-seven-five.
// Write a function fullWords(num: Int) to print (non-negative) integer numbers in full words.
object P95:
  private val Digit2Word = List(
    (1, "one"),
    (2, "two"),
    (3, "three"),
    (4, "four"),
    (5, "five"),
    (6, "six"),
    (7, "seven"),
    (8, "eight"),
    (9, "nine")
  )

  private def go(n: Int): Option[(String, Int)] =
    if n == 0 then None
    else
      val (left, right) = n /% 10
      Digit2Word.find(_._1 == right).map(x => (x._2, left))

  def fullWords(num: Int): String =
    if num > 0 then List.unfold(num)(go).reverse.mkString("-")
    else "zero"
