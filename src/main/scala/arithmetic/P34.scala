package arithmetic

// P34 (**) Calculate Euler's totient function phi(m).
//     Euler's so-called totient function phi(m) is defined as the number of
//     positive integers r (1 <= r < m) that are coprime to m.  As a special
//     case, phi(1) is defined to be 1.
//
//     scala> 10.totient
//     res0: Int = 4

object P34:
  private val f = (x: Int) => 1 - 1 / x.toDouble

  def totient(x: Int): Int =
    val y = P35
      .primeFactors(x)
      .map(f)
      .foldLeft(1.0d)(_ * _)

    (x * y).toInt
