package mtree

// P70 (**) Tree construction from a node string.
//
// We suppose that the nodes of a multiway tree contain single characters.
// In the depth-first order sequence of its nodes, a special character ^
// has been inserted whenever, during the tree traversal, the move is a
// backtrack to the previous level.
//
// By this rule, the tree in the figure opposite is represented as:
//
// afg^^c^bd^e^^^
// Define the syntax of the string and write a function string2MTree to construct
// an MTree from a String.  Make the function an implicit conversion from String.
// Write the reverse function, and make it the toString method of MTree.
//
// scala> MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e'))))).toString
// res0: String = afg^^c^bd^e^^^
object P70:
  def string2MTree(s: String): MTree[Char] =
    /*
    First recursive dfs call collects the children,
    second recursive dfs call collects the siblings.

    x=g, xs=^^c^bd^e^^^, ys=^c^bd^e^^^, zs=c^bd^e^^^
    x=e, xs=^^^, ys=^^, zs=^
    x=d, xs=^e^^^, ys=e^^^, zs=^
    x=b, xs=d^e^^^, ys=^, zs=
    x=c, xs=^bd^e^^^, ys=bd^e^^^, zs=
    x=f, xs=g^^c^bd^e^^^, ys=c^bd^e^^^, zs=
    x=a, xs=fg^^c^bd^e^^^, ys=, zs=
     */
    def loop(s: String): (List[MTree[Char]], String) =
      s match
        case ""      => (Nil, "")
        case s"^$xs" => (Nil, xs)
        case _ =>
          val (x, xs)        = (s.head, s.tail)
          val (children, ys) = loop(xs)
          val (siblings, zs) = loop(ys)
          (MTree(x, children) :: siblings, zs)

    loop(s)._1.head

  def tree2String(t: MTree[Char]): String =
    def loop(acc: DList[Char], t: MTree[Char]): DList[Char] =
      val xs = t.children.foldLeft(DList.empty[Char])(loop)
      val ys = DList.singleton(t.value) ++ xs ++ DList.singleton('^')
      acc ++ ys

    loop(DList.empty[Char], t).toList.mkString
