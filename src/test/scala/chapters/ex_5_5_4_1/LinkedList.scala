package chapters.ex_5_5_4_1

sealed trait LinkedList[T] {

  def map[A](f: T => A): LinkedList[A] = {
    this match {
      case Empty() => Empty[A]
      case Pair(h, t) => Pair(f(h), t.map(f))
    }
  }
}

final case class Empty[T]() extends LinkedList[T]
final case class Pair[T](head: T, tail: LinkedList[T]) extends LinkedList[T]

object Example extends App {
  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Empty())))

  println(list.map(_ * 2))
  println(list.map(_ + 1))
  println(list.map(_ / 3))
}