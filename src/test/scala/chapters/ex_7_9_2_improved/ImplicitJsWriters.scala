package chapters.ex_7_9_2_improved

import java.util.Date

import chapters.ex_7_9_common._

object ImplicitJsWriters {

  import chapters.ex_7_9_2.ImplicitJsUtil._

  implicit object StringWriter extends JsWriter[String] {
    def write(value: String) = JsString(value)
  }

  implicit object DateWriter extends JsWriter[Date] {
    def write(value: Date) = JsString(value.toString)
  }

  implicit object LongWriter extends JsWriter[Long] {
    def write(value: Long): JsValue = JsString(value.toString)
  }

  implicit object AnonymousJsWriter extends JsWriter[Anonymous] {
    override def write(anon: Anonymous): JsValue = {
      JsObject(Map(
        "id" -> anon.id.toJson,
        "createdAt" -> anon.createdAt.toJson,
        "age" -> anon.age.toJson
      ))
    }
  }

  implicit object UserJsWriter extends JsWriter[User] {
    override def write(user: User): JsValue = {
      JsObject(Map(
        "id" -> user.id.toJson,
        "email" -> user.email.toJson,
        "createdAt" -> user.createdAt.toString.toJson,
        "age" -> user.age.toString.toJson
      ))
    }
  }

  implicit object VisitorJsWriter extends JsWriter[Visitor] {
    def write(value: Visitor) = value match {
      case anon: Anonymous => anon.toJson
      case user: User => user.toJson
    }
  }

}