package chapters.ex_7_9

import chapters.ex_7_9_common._

object Workout {
    def main(args: Array[String]): Unit = {
      println(
        JsObject(Map(
          "foo" -> JsString("a"),
          "bar" -> JsString("b"),
          "baz" -> JsString("c")))
          .stringify
      )

      import ImplicitJsWriters._

      val anon = Anonymous("1234")
      println(JsUtil.toJson(anon).stringify)

      val user = User("5678", "a@a.aaa")
      println(JsUtil.toJson(user).stringify)

      val visitors: Seq[Visitor] = Seq(Anonymous("001"), User("003", "dave@xample.com"))
      visitors.foreach(v => println(JsUtil.toJson(v).stringify))
  }
}
