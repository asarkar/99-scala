package logic

// P49 (**) Gray code.
//     An n-bit Gray code is a sequence of n-bit strings constructed according
//     to certain rules. For example,
//     n = 1: C(1) = ("0", "1").
//     n = 2: C(2) = ("00", "01", "11", "10").
//     n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").
//
//     Find out the construction rules and write a function to generate Gray
//     codes.
//
//     scala> gray(3)
//     res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
//
//     See if you can use memoization to make the function more
//     efficient.

/*
ANSWER:
For number of bits n, there are 2^n Gray codes, including zero.
Thus, the maximum Gray code is 2^n - 1. Since, by definition,
Gray codes differ only by 1 bit from their neighbors, the i-th
Gray code is given by the XOR of the i-th and the (i - 1)th bits
of the binary representation of i, where 0 <= i < 2^n.

For the example above, n = 2, the corresponding Gray codes are:
0 ^ 0 = 0 (00), 1 ^ 0 = 1 (01), 2 ^ 1 = 3 (11) and, 3 ^ 1 = 2 (10)
 */

object P49:
  private def lpad(n: Int, s: String): String =
    ("0" * (n - s.length)) + s

  def gray(n: Int): List[String] =
    val x = 1 << n
    val f = (i: Int) => i ^ (i >> 1)
    (0 until x).map(i => s"${lpad(n, f(i).toBinaryString)}").toList
