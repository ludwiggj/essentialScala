package chapters.ex_3_1_6_6

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

class CounterAdder(val count: Int) {
  def inc: CounterAdder = inc()

  def dec: CounterAdder = dec()

  def inc(by: Int = 1) = new CounterAdder(count + by)

  def dec(by: Int = 1) = new CounterAdder(count - by)

  def adjust(adder: Adder) = {
    new CounterAdder(adder.add(count))
  }
}

object AdderCount  extends App {
  private val counter = new CounterAdder(10)

  println(counter.inc(by = 5).dec(by = 10).inc().inc().count)

  private val adder = new Adder(20)

  println(counter.adjust(adder).inc(by = 5).dec(by = 10).inc().inc().count)
}