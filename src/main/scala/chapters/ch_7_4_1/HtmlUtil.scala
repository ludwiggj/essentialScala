package chapters.ch_7_4_1

import chapters.ch_7_3.Person

object HtmlUtil {
  def htmlify[A](data: A)(implicit writer: HtmlWriter[A]): String = {
    writer.write(data)
  }
}

trait HtmlWriter[A] {
  def write(in: A): String
}

// Type class instance
object PersonWriter extends HtmlWriter[Person] {
  def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
}

object RockIt {

  def writeWithExplicitWriter() = {
    HtmlUtil.htmlify(Person("bill", "bAndb@flobalob.com"))(PersonWriter)
  }

  def writeWithImplictWriter() = {
    // Type class instance
    implicit object ApproximationWriter extends HtmlWriter[Int] {
      def write(in: Int): String =
        s"It's definitely less than ${((in / 10) + 1) * 10}"
    }

    HtmlUtil.htmlify(2)
  }

  def main(args: Array[String]): Unit = {
    println(writeWithExplicitWriter())
    println(writeWithImplictWriter())
  }
}