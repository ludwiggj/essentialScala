package chapters.ex_7_9_common

trait JsWriter[A] {
  def write(value: A): JsValue
}
