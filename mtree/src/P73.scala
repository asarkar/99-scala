package mtree

// P73 (**) Lisp-like tree representation.
// There is a particular notation for multiway trees in Lisp.
// Lisp is a prominent functional programming language.
// In Lisp almost everything is a list.
//
// Our example tree would be represented in Lisp as (a (f g) c (b d e)).
// The following pictures give some more examples.
//
// Note that in the "lispy" notation a node with successors (children) in
// the tree is always the first element in a list, followed by its children.
// The "lispy" representation of a multiway tree is a sequence of atoms and
// parentheses '(' and ')', with the atoms separated by spaces.
// We can represent this syntax as a Scala String.
// Write a method lispyTree which constructs a "lispy string" from an MTree.
//
// scala> MTree("a", List(MTree("b", List(MTree("c"))))).lispyTree
// res0: String = (a (b c))
//
// As a second, even more interesting, exercise try to write a method that
// takes a "lispy" string and turns it into a multiway tree.
object P73:
  private def loop(s: String, i: Int): (MTree[Char], Int) =
    if i >= s.length() then throw StringIndexOutOfBoundsException(s"String index out of range: $i")
    else if s(i).isLetter then (MTree(s(i)), i + 1)
    else if s(i) == '(' then
      val x = s(i + 1)
      val xs = IndexedSeq.unfold(i + 2)(j =>
        Option.when(j < s.length() && s(j) != ')') {
          val x = loop(s, j)
          ((x, x._2))
        }
      )
      (MTree(x, xs.map(_._1)), xs.last._2 + 1)
    else loop(s, i + 1)

  def lispyString2Tree(s: String): MTree[Char] =
    loop(s, 0)._1

  extension [A](t: MTree[Char])
    def lispyTree: String =
      def loop(acc: DList[Char], t: MTree[Char]): DList[Char] =
        if t.children.isEmpty then
          acc
            ++ DList.singleton(' ')
            ++ DList.singleton(t.value)
        else
          val xs = t.children.foldLeft(DList.empty[Char])(loop)
          acc
            ++ DList.singleton(' ')
            ++ DList.singleton('(')
            ++ DList.singleton(t.value)
            ++ xs
            ++ DList.singleton(')')

      loop(DList.empty[Char], t).toList.tail.mkString
