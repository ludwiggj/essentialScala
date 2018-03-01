package chapters.ex_7_9_2

import chapters.ex_7_9_common.{JsValue, JsWriter}

object ImplicitJsUtil {

  implicit class JsUtil[A: JsWriter](value: A) {
    def toJson: JsValue = {
      implicitly[JsWriter[A]].write(value)
    }
  }
}