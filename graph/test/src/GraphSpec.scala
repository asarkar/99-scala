package graph

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class GraphSpec extends AnyFunSpec:
  private def freq[A](xs: Iterable[A]): Map[A, Int] =
    xs.groupMapReduce(identity)(_ => 1)(_ + _)

  private def edge2Str[A, B](sep: Char)(e: Edge[A, B]): String =
    e match
      case Edge(u, v, Some(d)) => s"$u$sep$v/$d"
      case Edge(u, v, None)    => s"$u$sep$v"

  describe("undirected graph"):
    it("without edge weights"):
      val graph    = Graph.fromString("[p-q, m-q, k, p-m]")
      val vertices = List("p", "q", "m", "k")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('-'))
        .sorted shouldBe List("m-p", "m-q", "p-m", "p-q", "q-m", "q-p")

    it("with edge weights"):
      val graph    = Graph.fromString("[p-q/9, m-q/7, k, p-m/5]")
      val vertices = List("p", "q", "m", "k")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('-'))
        .sorted shouldBe List("m-p/5", "m-q/7", "p-m/5", "p-q/9", "q-m/7", "q-p/9")

    it("from duplicate edges"):
      val graph    = Graph.fromString("[p-q, m-q, p-q]")
      val vertices = List("p", "q", "m")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('-'))
        .sorted shouldBe List("m-q", "p-q", "q-m", "q-p")

    it("from duplicate edges with weights"):
      val graph    = Graph.fromString("[p-q/9, m-q/7, p-q/5]")
      val vertices = List("p", "q", "m")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('-'))
        .sorted shouldBe List("m-q/7", "p-q/9", "q-m/7", "q-p/9")
    it("from reverse edge"):
      val graph    = Graph.fromString("[p-q/9, q-p/5]")
      val vertices = List("p", "q")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('-'))
        .sorted shouldBe List("p-q/9", "q-p/5")
    it("from reverse edge -- 2"):
      val graph    = Graph.fromString("[p-q/5, q-p/9]")
      val vertices = List("p", "q")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('-'))
        .sorted shouldBe List("p-q/5", "q-p/9")
    it("disconnected"):
      val vertices = List(1, 2, 3)
      val graph    = Graph.buildUG(vertices, List(Edge(1, 2, None)))
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('-'))
        .sorted shouldBe List("1-2", "2-1")

  describe("directed graph"):
    it("without edge weights"):
      val graph    = Graph.fromString("[p>q, m>q, k, p>m]")
      val vertices = List("p", "q", "m", "k")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('>'))
        .sorted shouldBe List("m>p", "m>q", "p>m", "p>q", "q>m", "q>p")

    it("with edge weights"):
      val graph    = Graph.fromString("[p>q/9, m>q/7, k, p>m/5]")
      val vertices = List("p", "q", "m", "k")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('>'))
        .sorted shouldBe List("m>p/5", "m>q/7", "p>m/5", "p>q/9", "q>m/7", "q>p/9")

    it("from duplicate edges"):
      val graph    = Graph.fromString("[p>q, m>q, p>q]")
      val vertices = List("p", "q", "m")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('>'))
        .sorted shouldBe List("m>q", "p>q", "q>m", "q>p")

    it("from duplicate edges with weights"):
      val graph    = Graph.fromString("[p>q/9, m>q/7, p>q/5]")
      val vertices = List("p", "q", "m")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('>'))
        .sorted shouldBe List("m>q/7", "p>q/9", "q>m/7", "q>p/9")
    it("from reverse edge"):
      val graph    = Graph.fromString("[p>q/9, q>p/5]")
      val vertices = List("p", "q")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('>'))
        .sorted shouldBe List("p>q/9", "q>p/5")
    it("from reverse edge -- 2"):
      val graph    = Graph.fromString("[p>q/5, q>p/9]")
      val vertices = List("p", "q")
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('>'))
        .sorted shouldBe List("p>q/5", "q>p/9")
    it("disconnected"):
      val vertices = List(1, 2, 3)
      val graph    = Graph.buildG(vertices, List(Edge(1, 2, None)))
      freq(graph.vertices) shouldBe freq(vertices)

      graph.edges
        .map(edge2Str('>'))
        .sorted shouldBe List("1>2")
