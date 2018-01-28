package chapters.ch_5_1_2

// Invariant Generic Sum Type Pattern
sealed trait Result[A]
final case class Success[A](result: A) extends Result[A]
final case class Failure[A](result: String) extends Result[A]
