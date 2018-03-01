package chapters.ch_7_3.take1

trait HtmlWritable {
  def toHtml: String
}

final case class Person(name: String, email: String) extends HtmlWritable {
  def toHtml = s"<span>$name &lt;$email&gt;</span>"
}

object Test {
  def main(args: Array[String]): Unit = {
    println(Person("jon", "jon@example.com").toHtml)
  }
}