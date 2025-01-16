package mtree

// P70C (*) Count the nodes of a multiway tree.
// Write a method nodeCount which counts the nodes of a given multiway tree.
//
// scala> MTree('a', List(MTree('f'))).nodeCount
// res0: Int = 2
object P70C:
  extension [A](t: MTree[A])
    def nodeCount: Int = 1 + t.children.foldLeft(0)((acc, c) => acc + c.nodeCount)
