package chapters.ex_5_4_3_1

sealed trait Sum[A, B] {
  def fold[C](left: A => C, right: B => C): C = {
    this match {
      case Left(value) => left(value)
      case Right(value) => right(value)
    }
  }
}

final case class Left[A, B](value: A) extends Sum[A, B]

final case class Right[A, B](value: B) extends Sum[A, B]

object SumWorkout extends App {
  private val val1 = Left[Int, String](1)
  println(val1.value)

  println(val1.fold[String](x => (x + 4).toString(), _ + " Four"))

  private val val2 = Right[Int, String]("foo")
  println(val2.value)

  println(val2.fold[String](x => (x + 4).toString(), _ + " Four"))

  val sum: Sum[Int, String] = Right("foo")
  println(sum)

  println(sum match {
    case Left(x) => x.toString
    case Right(x) => x
  })

  def intOrString(input: Boolean): Sum[Int, String] =
    if (input == true) {
      Left[Int, String](123)
    } else {
      Right[Int, String]("abc")
    }
}
