package list

// P16 (**) Drop every Nth element from a list.
//
// scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

object P16:

  def drop[A](n: Int, l: List[A]): List[A] =
    // Other ways:
    //   xs.withFilter(...).map(...)
    //   for (..) yield
    //   xs.flatMap(...)
    l.zipWithIndex.collect:
      case (x, i) if (i + 1) % n != 0 => x
