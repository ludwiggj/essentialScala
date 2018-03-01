package chapters.ex_7_9_2_improved

import chapters.ex_7_9_common.{Visitor,Anonymous,User}

object Workout {
    def main(args: Array[String]): Unit = {
      import chapters.ex_7_9_2.ImplicitJsUtil._
      import ImplicitJsWriters._

      println(Anonymous("abc").toJson.stringify)

      println(User("def", "g@h.ijk").toJson.stringify)

      val visitors: Seq[Visitor] = Seq(Anonymous("001"), User("003", "dave@xample.com"))
      visitors.foreach(v => println(v.toJson.stringify))
  }
}
