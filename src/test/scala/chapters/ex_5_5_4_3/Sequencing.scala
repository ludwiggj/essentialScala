package chapters.ex_5_5_4_3

object Sequencing extends App {
  val list = List(1, 2, 3)

  val newList = list.flatMap(n => List(n, -n))

  println(newList)
}
