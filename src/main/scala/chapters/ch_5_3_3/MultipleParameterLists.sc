def example(x: Int)(y: Int) = x + y

example(1)(2)

final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

final case class End[A]() extends LinkedList[A]

sealed trait LinkedList[A] {
  def fold[B](end: B)(pair: (A, B) => B): B =
    this match {
      case End() => end
      case Pair(hd, tl) => pair(hd, tl.fold(end)(pair))
    }

  def length: Int = fold[Int](0) { (h, t) => 1 + t }
}

Pair(1, Pair(2, Pair(3, End()))).length