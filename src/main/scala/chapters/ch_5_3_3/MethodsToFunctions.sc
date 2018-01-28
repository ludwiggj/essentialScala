object Sum {
  def sum(x: Int, y: Int) = x + y

  def doIt(x: Int, y: Int, f: (Int, Int) => Int) = {
    f(x, y)
  }
}

Sum.sum(1, 2)

val f = (Sum.sum _)

f(1, 2)

Sum.doIt(1, 2, _ + _)

Sum.doIt(3, 6, Sum.sum)