package chapters.ex_3_1_6_4

class Counter(val count: Int) {
  def inc = new Counter(count + 1)
  def dec = new Counter(count - 1)
}

object Count extends App {
  println(new Counter(10).inc.dec.inc.inc.count)
}