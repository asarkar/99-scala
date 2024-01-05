package arithmetic

// P31 (**) Determine whether a given integer number is prime.
//     scala> 7.isPrime
//     res0: Boolean = true

object P31:
  def isPrime(n: Int): Boolean =
    if n == 2 || n == 3
    then true
    else if n <= 1 || (n % 2) == 0 || (n % 3) == 0
    then false
    else
      val i     = Math.sqrt(n.toDouble).toInt
      val prime = (j: Int) => (n % j) != 0 && (n % (j + 2)) != 0
      (5 to i).forall(prime)
