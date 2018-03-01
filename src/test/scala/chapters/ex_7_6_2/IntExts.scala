package chapters.ex_7_6_2

object IntImplicits {

  implicit class IntPoweredUp(baseInt: Int) {
    def yeah {
      for (_ <- 1 to baseInt) {
        println("Oh yeah!")
      }
    }

    def yeahYeah {
      times(_ => println("Oh yeah!"))
    }

    def times(f: Int => Unit): Unit = {
      for (i <- 0 until baseInt) {
        f(i)
      }
    }
  }

}

object ImplicitIntWorkout {

  def intYeahs() = {
    import IntImplicits._

    println("3...")
    3.yeah
    println("0...")
    0.yeah
    println("-1...")
    (-1).yeah
    println("Done")

    3.times(i => println(s"Look, it's the number $i"))

    println("5...")
    5.yeahYeah
    println("0...")
    0.yeahYeah
    println("-1...")
    (-1).yeahYeah
    println("Done")
  }

  def main(args: Array[String]): Unit = {
    intYeahs()
  }
}