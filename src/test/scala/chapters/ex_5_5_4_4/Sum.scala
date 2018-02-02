package chapters.ex_5_5_4_4

sealed trait Sum[A, B] {
  def fold[C](failure: A => C, success: B => C): C = {
    this match {
      case Failure(value) => failure(value)
      case Success(value) => success(value)
    }
  }

  def map[C](f: B => C): Sum[A, C] = {
    this match {
      case Failure(value) => Failure(value)
      case Success(value) => Success(f(value))
    }
  }

  def flatMap[C](f: B => Sum[A, C]): Sum[A, C] = {
    this match {
      case Failure(value) => Failure(value)
      case Success(value) => f(value)
    }
  }
}

final case class Failure[A, B](value: A) extends Sum[A, B]

final case class Success[A, B](value: B) extends Sum[A, B]

object SumWorkout extends App {
  private val val1 = Failure[String, Int]("Oh dear")
  println(val1)
  println(val1 map {_ * 2})
  println(val1 flatMap { x => Success(x * 2)})

  private val val2 = Success[String, Int](15)
  println(val2)
  println(val2 map {_ * 2})
  println(val2 flatMap { x => Success(x * 2)})
}
