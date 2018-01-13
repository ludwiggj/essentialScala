package chapters.ex_3_1_6_5

class FasterCounter(val count: Int) {
  def inc: FasterCounter = inc()
  def dec: FasterCounter = dec()
  def inc(by: Int = 1) = new FasterCounter(count + by)
  def dec(by: Int = 1) = new FasterCounter(count - by)
}

object FasterCount extends App {
  println(new FasterCounter(10).inc(by = 5).dec(by = 10).inc().inc().count)
}