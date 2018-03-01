package chapters.ex_7_9

import chapters.ex_7_9_common.{JsValue, JsWriter}

object JsUtil {
  def toJson[A](value: A)(implicit writer: JsWriter[A]): JsValue = {
    writer.write(value)
  }
}