package chapters.ex_5_2_3_1

sealed trait LinkedList {
  def fold(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def sum: Int = {
    fold(0, (x, y) => x + y)
  }

  def length: Int = {
    fold(0, (_, y) => 1 + y)
  }

  def product: Int = {
    fold(1, (x, y) => x * y)
  }
}

final case object End extends LinkedList

final case class Pair(head: Int, tail: LinkedList) extends LinkedList

object WorkIt extends App {
  val example = Pair (1, Pair (2, Pair (3, End ) ))

  assert (example.sum == 6)

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End.length == 0)

  assert (example.product == 6)
}