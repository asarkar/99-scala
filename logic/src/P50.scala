package logic

import collection.immutable.SortedMap

// P50 (***) Huffman code.
// First of all, consult a good book on discrete mathematics or algorithms
// for a detailed description of Huffman codes!
//
// We suppose a set of symbols with their frequencies, given as a list of
// (S, F) Tuples.  E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16),
// ("e", 9), ("f", 5)).  Our objective is to construct a list of (S, C)
// Tuples, where C is the Huffman code word for the symbol S.
//
// scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
// res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))

object P50:
  private enum HTree:
    case Leaf(v: String)
    case Branch(left: HTree, right: HTree)

    /*
    Although Huffman coding doesn't specify which of the
    two values to put on which side (i.e., left or right),
    the examples put the smaller value on the left.
    Also, the examples encode the left branch as 0.
     */
    def toList: List[(String, String)] =
      this match
        case HTree.Leaf(v) => List((v, ""))
        case HTree.Branch(left, right) =>
          val l = left.toList
          val r = right.toList
          l.map((k, v) => (k, '0' +: v)) ++ r.map((k, v) => (k, '1' +: v))

  private type Item = (String, (Int, HTree))

  private given Ordering[Item] = Ordering.by(_(1)(0))

  // Since Scala PriorityQueue is mutable, we use the SortedMap instead.
  private def huffman(map: SortedMap[String, (Int, HTree)]): HTree =
    map.size match
      case 1 => map.head(1)(1)
      case _ =>
        val (k1, (p1, t1)) = map.min
        val m1             = map - k1
        val (k2, (p2, t2)) = m1.min
        val m2             = m1 - k2
        val tree =
          if p1 < p2
          then HTree.Branch(t1, t2)
          else HTree.Branch(t2, t1)

        huffman(m2 + (k1 + k2 -> (p1 + p2, tree)))

  def huffman(freq: List[(String, Int)]): List[(String, String)] =
    val map = SortedMap.from(freq.map((s, i) => (s, (i, HTree.Leaf(s)))))
    huffman(map).toList
