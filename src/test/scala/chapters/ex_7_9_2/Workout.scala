package chapters.ex_7_9_2

import chapters.ex_7_9_common._

object Workout {
    def main(args: Array[String]): Unit = {
      import ImplicitJsUtil._
      import ImplicitJsWriters._

      println(Anonymous("abc").toJson.stringify)

      println(User("def", "g@h.ijk").toJson.stringify)

      val visitors: Seq[Visitor] = Seq(Anonymous("001"), User("003", "dave@xample.com"))
      visitors.foreach(v => println(v.toJson.stringify))
  }
}
