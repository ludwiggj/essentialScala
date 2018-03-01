package chapters.ch_7_3.take2

import java.util.Date

import chapters.ch_7_3.take1.Person

object HtmlWriter {
  def write(in: Any): String =
    in match {
      case Person(name, email) => s"<span>$name &lt;$email&gt;</span>"
      case d: Date => ???
      case _ => throw new Exception(s"Can't render ${in} to HTML")
    }

  def main(args: Array[String]): Unit = {
    println(write(Person("bart", "bart@springfield.com")))
    println(write("lisa"))
  }
}
