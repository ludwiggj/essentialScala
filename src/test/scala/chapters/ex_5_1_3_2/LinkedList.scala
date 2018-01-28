package chapters.ex_5_1_3_2

sealed trait LinkedList[A] {
  def length: Int = this match {
    case Pair(_, tail) => 1 + tail.length
    case End() => 0
  }

  def contains(value: A): Boolean = this match {
    case Pair(h, t) => (value == h) || t.contains(value)
    case End() => false
  }

  def apply(pos: Int): A = {
    if (pos < 0) throw new Exception("Bad things happened")
    this match {
      case End() => throw new Exception("Bad things happened")
      case Pair(h, t) => if (pos == 0) h else t(pos - 1)
    }
  }
}

// final case object End extends LinkedList[Nothing]

final case class End[A]() extends LinkedList[A]

final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

object Exercise extends App {
  val example = Pair(1, Pair(2, Pair(3, End())))

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End().length == 0)

  assert(example.contains(3) == true)
  assert(example.contains(4) == false)
  assert(End().contains(0) == false)

  // This should not compile
  // example.contains("not an Int")

  assert(example(0) == 1)
  assert(example(1) == 2)
  assert(example(2) == 3)

  assert(try {
    example(3)
    false
  } catch {
    case e: Exception => true
  })
}