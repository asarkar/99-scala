package list

import scala.annotation.tailrec

// P02 (*) Find the last but one element of a list.
//
// scala> penultimate(List(1, 1, 2, 3, 5, 8))
// res0: Int = 5

object P02:
  @tailrec
  def penultimate[A](l: List[A]): A = l match
    case x :: _ :: Nil => x
    case _ :: tail     => penultimate(tail)
    case Nil           => throw new NoSuchElementException("penultimate of singleton list")
