package chapters.ex_3_4_5_3

class Adder(amount: Int) {
  def apply(in: Int): Int = in + amount
}

case class Counter(count: Int = 0) {
  def inc = copy(count + 1)
  def dec = copy(count - 1)
  def adjust(adder: Adder) = copy(count = adder(count))
}

object Count extends App {
  println(Counter(10).inc.dec.inc.inc)

  val adder = new Adder(5)

  println(Counter(10).adjust(adder).inc.dec.inc.inc)

  println(Counter().inc.dec == Counter().dec.inc)
}