package arithmetic

// P32 (**) Determine the greatest common divisor of two positive integer
// numbers.
// Use Euclid's algorithm.
//
// scala> gcd(36, 63)
// res0: Int = 9

object P32:
  def gcd(x: Int, y: Int): Int =
    if y == 0
    then x
    else if x < y
    then gcd(y, x)
    else gcd(y, x % y)
