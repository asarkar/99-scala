package list

// P24 (*) Lotto: Draw N different random numbers from the set 1..M.
//
// scala> lotto(6, 49)
// res0: List[Int] = List(23, 1, 17, 33, 21, 37)

object P24:
  def lotto(n: Int, m: Int): List[Int] =
    P23.randomSelect(n, P22.range(1, m))
