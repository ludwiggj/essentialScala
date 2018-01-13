package chapters.ch_5_5_2

/*
   If A is a B or C, and we want to write a method f accepting an A and returning an F, define a pattern matching case
   for B and C.
 */

trait AA
final case class BB() extends AA
final case class CC() extends AA

object anotherExample {
  def f(a: AA): F = a match {
    case BB() => ???
    case CC() => ???
  }
}

