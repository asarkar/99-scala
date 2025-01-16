package mtree

// P72 (*) Construct the postorder sequence of the tree nodes.
//
// Write a method postorder which constructs the postorder sequence
// of the nodes of a multiway tree.  The result should be a List.
//
// scala> "afg^^c^bd^e^^^".postorder
// res0: List[Char] = List(g, f, c, d, e, b, a)
object P72:

  extension [A](t: MTree[A])
    private def loop(acc: List[A]): List[A] =
      t.children.foldRight(t.value :: acc)((tree, xs) => tree.loop(xs))

    def postorder: List[A] =
      loop(Nil)
