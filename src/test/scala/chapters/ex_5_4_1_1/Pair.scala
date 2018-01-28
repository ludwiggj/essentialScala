package chapters.ex_5_4_1_1

case class Pair[A, B](val one: A, val two: B)

object PairWorkout extends App {
  val pair = Pair[String, Int]("hi", 2)
  println(s"${pair.one} ${pair.two}")
}
