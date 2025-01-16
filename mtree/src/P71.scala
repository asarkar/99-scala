package mtree

// P71 (*) Determine the internal path length of a tree.
// We define the internal path length of a multiway tree as the
// total sum of the path lengths from the root to all nodes of the tree.
// By this definition, the tree in the figure of problem P70 has an
// internal path length of 9.  Write a method internalPathLength to return that sum.
//
// scala> "afg^^c^bd^e^^^".internalPathLength
// res0: Int = 9
/*
ANSWER: We observe that the path length is equal to the number of
nodes in a path from the root to a leaf, with a node counted only
once. So, path length of abd = 3, but abd + abe is 4, not 6.

The catch is to pass the _same_ accoumulated value to all the
children of a node.
 */
object P71:

  extension [A](t: MTree[A])
    private def loop(acc: Int): Int =
      acc + t.children.map(_.loop(acc + 1)).sum

    def internalPathLength: Int =
      loop(0)
