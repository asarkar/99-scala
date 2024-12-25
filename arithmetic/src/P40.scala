package arithmetic

// P40 (**) Goldbach's conjecture.
//     Goldbach's conjecture says that every positive even number greater than 2
//     is the sum of two prime numbers.  E.g. 28 = 5 + 23.  It is one of the
//     most famous facts in number theory that has not been proved to be correct
//     in the general case.  It has been numerically confirmed up to very large
//     numbers (much larger than Scala's Int can represent).  Write a function
//     to find the two prime numbers that sum up to a given even integer.
//
//     scala> 28.goldbach
//     res0: (Int, Int) = (5,23)

object P40:
  // This implementation isn't very efficient because the primes are generated
  // eagerly. It works much better in Haskell where list is lazy.
  def goldbach(n: Int): (Int, Int) =
    P39
      .primesInRng(2, n - 2)
      .collect:
        case x if P31.isPrime(n - x) => (x, n - x)
      .head
