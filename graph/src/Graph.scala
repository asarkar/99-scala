package graph

import scala.util.matching.Regex

case class Edge[A, B](u: A, v: A, data: Option[B]):
  def reverse: Edge[A, B] = Edge(v, u, data)

class Graph[A, B] private (adj: Map[A, Set[(A, Option[B])]]):
  def vertices: Set[A] =
    adj.toList.flatMap((x, xs) => xs.map(_._1) + x).toSet

  def edges: List[Edge[A, B]] =
    adj.toList.flatMap((u, vs) => vs.map(v => Edge(u, v._1, v._2)))

  def neighbors(u: A): Set[(A, Option[B])] = adj.getOrElse(u, Set.empty)

  // def addVertex(u: A): Graph[A, B] = Graph(adj + (u -> Set.empty))

  def size: Int = adj.size

object Graph:
  // Build a directed graph.
  def buildG[A, B](vertices: List[A], edges: List[Edge[A, B]]): Graph[A, B] =
    val z = vertices.map(_ -> Set.empty[(A, Option[B])]).toMap
    val adj = edges
      .distinctBy(e => (e.u, e.v))
      .foldRight(z) { case (e, m) =>
        m.updatedWith(e.u):
          case Some(xs) => Some(xs + (e.v -> e.data))
          case _        => Some(Set(e.v -> e.data))
      }
    new Graph(adj)

  /*
    Build an undirected graph.
    Since the graph may contain cycles, make sure
    to not include the same vertex more than once.
   */
  def buildUG[A, B](vertices: List[A], edges: List[Edge[A, B]]): Graph[A, B] =
    buildG(vertices, edges ++ edges.map(_.reverse))

  private def parseString(s: String): (List[Edge[String, String]], List[String]) =
    if !s.startsWith("[") || !s.endsWith("]")
    then throw IllegalArgumentException("string must be enclosed by '[' and ']'")
    else
      val edgePattern: Regex = """[^-/>]+""".r

      s
        .substring(1, s.length() - 1)
        .split(",")
        .map(_.trim())
        .foldRight((List.empty[Edge[String, String]], List.empty[String])) { case (x, (es, vs)) =>
          edgePattern.findAllIn(x).toList match
            case u :: Nil           => (es, u :: vs)
            case u :: v :: Nil      => (Edge(u, v, None) :: es, vs)
            case u :: v :: d :: Nil => (Edge(u, v, Some(d)) :: es, vs)
            case _                  => throw IllegalArgumentException(s"unknown format: $x")
        }

  def fromString(s: String): Graph[String, String] =
    val (edges, vertices) = parseString(s)
    buildUG(vertices, edges)

  def fromStringLabel(s: String): Graph[String, String] =
    val (edges, vertices) = parseString(s)
    buildG(vertices, edges)
