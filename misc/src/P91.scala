package misc
// P91 (**) Knight’s tour.
// Another famous problem is this one: How can a knight jump on an NxN chessboard in such a way
// that it visits every square exactly once?
//
// Hints: Represent the squares by pairs of their coordinates of the form (X,Y), where both
// X and Y are integers between 1 and N. (Alternately, define a Point class for the same purpose.)
// Write a function jumps(N,(X,Y)) to list the squares that a knight can jump to from (X,Y) on a
// NxN chessboard.And finally, represent the solution of our problem as a list of knight positions
// (the knight’s tour).
//
// It might be nice to find more than one tour, but a computer will take a long time trying to find
// them all at once. Can you make a lazy list that only calculates the tours as needed?
//
// Can you find only "closed tours", where the knight can jump from its final position back to its
// starting position?
object P91:
  private type Square = (x: Int, y: Int)
  private val moves: LazyList[Square] = LazyList(
    (2, 1),
    (1, 2),
    (-1, 2),
    (-2, 1),
    (-2, -1),
    (-1, -2),
    (1, -2),
    (2, -1)
  )

  def allSquares(n: Int): LazyList[Square] = LazyList
    .iterate((x = 0, y = 0)) { curr =>
      if curr.y == n - 1 then (curr.x + 1, 0)
      else (curr.x, curr.y + 1)
    }
    .takeWhile(_.x < n)

  def allKnightsTours(n: Int): LazyList[List[Square]] =
    allSquares(n)
      .map(knightsTour(n, Map.empty, _))

  private def knightsTour(n: Int, visited: Map[Square, Int], curr: Square): List[Square] =
    // To find a closed tour, also check if the next moves contain the start square.
    if visited.size == n * n - 1 then visited.toList.sortBy(_._2).map(_._1) :+ curr
    else
      /*
      It is imperative that nextMoves is lazy,
      otherwise even after finding a tour,
      it keeps of trying to find others.
       */
      val vs = visited + (curr -> (visited.size + 1))
      nextMoves(n, vs, curr)
        .sortBy(mv => nextMoves(n, vs, mv).size) // Warnsdorff's heuristic
        .map(nxt => knightsTour(n, vs, nxt))
        .find(_.size == n * n)
        .getOrElse(List.empty)

  private def nextMoves(n: Int, visited: Map[Square, Int], curr: Square): LazyList[Square] =
    moves
      .filter { mv =>
        val x = curr.x + mv.x
        val y = curr.y + mv.y
        x >= 0 && x < n && y >= 0 && y < n && !visited.contains((x, y))
      }
      .map(mv => (curr.x + mv.x, curr.y + mv.y))
