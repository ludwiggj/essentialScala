package chapters.ex_5_1_3_2

sealed trait Result[A]
final case class Success[A](result: A) extends Result[A]
final case class Failure[A](result: String) extends Result[A]

sealed trait LinkedListSansException[A] {
  def apply(pos: Int): Result[A] = {
    if (pos < 0) Failure("Index out of bounds")
    this match {
      case EndSansException() => Failure("Index out of bounds")
      case PairSansException(h, t) => if (pos == 0) Success(h) else t(pos - 1)
    }
  }
}

final case class EndSansException[A]() extends LinkedListSansException[A]

final case class PairSansException[A](head: A, tail: LinkedListSansException[A]) extends LinkedListSansException[A]

object SansExceptionExercise extends App {
  val example = PairSansException(1, PairSansException(2, PairSansException(3, EndSansException())))

  assert(example(0) == Success(1))
  assert(example(1) == Success(2))
  assert(example(2) == Success(3))
  assert(example(3) == Failure("Index out of bounds"))
}