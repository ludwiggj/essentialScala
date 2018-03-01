package chapters.ex_7_9_common

import chapters.ex_7_9.JsUtil

object ImplicitJsWriters {

  implicit object AnonymousJsWriter extends JsWriter[Anonymous] {
    override def write(anon: Anonymous): JsValue = {
      JsObject(Map(
        "id" -> JsString(anon.id),
        "createdAt" -> JsString(anon.createdAt.toString),
        "age" -> JsString(anon.age.toString)
      ))
    }
  }


  implicit object UserJsWriter extends JsWriter[User] {
    override def write(user: User): JsValue = {
      JsObject(Map(
        "id" -> JsString(user.id),
        "email" -> JsString(user.email),
        "createdAt" -> JsString(user.createdAt.toString),
        "age" -> JsString(user.age.toString)
      ))
    }
  }

  implicit object VisitorJsWriter extends JsWriter[Visitor] {
    def write(value: Visitor) = value match {
      case anon: Anonymous => JsUtil.toJson(anon)
      case user: User => JsUtil.toJson(user)
    }
  }
}