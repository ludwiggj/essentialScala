package chapters.ex_5_6_6_2

sealed trait Sum[+A, +B] {
  def flatMap[AA >: A, C](f: B => Sum[AA, C]): Sum[AA, C] = {
    this match {
      case Failure(value) => Failure(value)
      case Success(value) => f(value)
    }
  }

  def map[C](f: B => C): Sum[A, C] = {
    this match {
      case Failure(value) => Failure(value)
      case Success(value) => Success(f(value))
    }
  }

  def fold[C](failure: A => C, success: B => C): C =
    this match {
      case Failure(value) => failure(value)
      case Success(value) => success(value)
    }
}

final case class Failure[A, B](value: A) extends Sum[A, B]

final case class Success[A, B](value: B) extends Sum[A, B]

object SumWorkout extends App {
  private val val1 = Failure[String, Int]("Oh dear")
  println(val1)
  println(val1 map[Int]( x => x * 4 ))
  println(val1 flatMap { x => Success(x * 2) })
  println(val1.fold[String](x => s"$x $x", y => (y * 3).toString))

  private val val2 = Success[String, Int](15)
  println(val2)
  println(val2 map[Int]( x => x * 4 ))
  println(val2 flatMap { x => Success(x * 2) })
  println(val2.fold[String](x => s"$x $x", y => (y * 3).toString))
}