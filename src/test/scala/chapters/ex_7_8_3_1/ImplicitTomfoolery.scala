package chapters.ex_7_8_3_1

object ImplicitTomfoolery {

  object IntImplicits1 {

    implicit class IntOps(n: Int) {
      def yeah =
        times(_ => println("Oh yeah!"))

      def times(func: Int => Unit) =
        for (i <- 0 until n) func(i)
    }

  }

  object IntImplicits2 {

    class IntOps(n: Int) {
      def yeah =
        times(_ => println("Oh yeah!"))

      def times(func: Int => Unit) =
        for (i <- 0 until n) func(i)
    }

    implicit def intToIntOps(a: Int) = new IntOps(a)
  }

  def implicitClassExample(): Unit = {
    import IntImplicits1._

    2.yeah
    3.yeah
    (-1).yeah

    3.times(i => println(s"Look - it's the number $i!"))
  }

  def implicitConversionExample(): Unit = {
    import IntImplicits2._

    2.yeah
    3.yeah
    (-1).yeah

    3.times(i => println(s"Look - it's the number $i!"))
  }

  def main(args: Array[String]): Unit = {
    implicitClassExample()
    implicitConversionExample()
  }
}