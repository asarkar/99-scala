package arithmetic

// P33 (*) Determine whether two positive integer numbers are coprime.
// Two numbers are coprime if their greatest common divisor equals 1.
//
// scala> 35.isCoprimeTo(64)
// res0: Boolean = true

object P33:
  def isCoprime(x: Int, y: Int): Boolean =
    P32.gcd(x, y) == 1
