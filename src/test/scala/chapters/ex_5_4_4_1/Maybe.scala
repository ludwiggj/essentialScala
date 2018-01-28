package chapters.ex_5_4_4_1

sealed trait Maybe[A] {
  def fold[B](empty: B, full: A => B): B = {
    this match {
      case Empty() => empty
      case Full(value) => full(value)
    }
  }
}

final case class Full[A](value: A) extends Maybe[A]

final case class Empty[A]() extends Maybe[A]

object MaybeWorkout extends App {
  val perhapsEmpty: Maybe[Int] = Empty[Int]
  val perhapsFull: Maybe[Int] = Full(1)

  println(perhapsEmpty.fold[Int](-1, _ * 2))
  println(perhapsFull.fold[Int](-1, _ * 2))
}