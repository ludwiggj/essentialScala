package chapters.ex_5_2_3_1.generic

sealed trait LinkedList {
  def fold[T](end: T, f: (Int, T) => T): T =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def sum: Int = {
    fold[Int](0, (h, t) => h + t)
  }

  def length: Int = {
    fold[Int](0, (_, t) => 1 + t)
  }

  def product: Int = {
    fold[Int](1, (h, t) => h * t)
  }

  def double: LinkedList = {
    fold[LinkedList](End, (h, t) => Pair(h * 2, t))
  }
}

final case object End extends LinkedList
final case class Pair(head: Int, tail: LinkedList) extends LinkedList

object GenericWorkIt extends App {
  val example = Pair (1, Pair (2, Pair (3, End ) ))
  val exampleDoubled = Pair (2, Pair (4, Pair (6, End ) ))

  assert (example.sum == 6)

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End.length == 0)

  assert (example.double == exampleDoubled)
}