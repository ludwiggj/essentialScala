package chapters.ch_3_2_1

class Adder(amount: Int) {
  // apply on a class
  def apply(in: Int): Int = in + amount
}

object Adder {
  // apply on an object
  def apply(in: Int) = new Adder(in)
}

object Workout extends App {
  val add3 = new Adder(3)
  println(add3(2))

  val add5 = Adder(5)

  println(add5(2))
}