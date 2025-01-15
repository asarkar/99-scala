package arithmetic

// P35 (**) Determine the prime factors of a given positive integer.
// Construct a flat list containing the prime factors in ascending order.
//
// scala> 315.primeFactors
// res0: List[Int] = List(3, 3, 5, 7)

object P35:
  private val primes = LazyList.iterate(2) { n =>
    Iterator
      .from(n + 1)
      .dropWhile(!P31.isPrime(_))
      .next()
  }

  private def primeFactors(ll: LazyList[Int], x: Int): List[Int] =
    if x <= 1
    then Nil
    else
      val k = ll.head
      if x > 1 && x % k == 0
      then k :: primeFactors(ll, x / k)
      else primeFactors(ll.tail, x)

  def primeFactors(x: Int): List[Int] = primeFactors(primes, x)
