package chapters.ch_3_2_1

class Adder(amount: Int) {
  def apply(in: Int): Int = in + amount
}

object Workout extends App {
  val add3 = new Adder(3)
  println(add3(2))
}