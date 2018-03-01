package chapters.ch_7_4_2

import chapters.ch_7_3.Person

// Type class interface pattern
object HtmlWriter {
  def apply[A](implicit writer: HtmlWriter[A]): HtmlWriter[A] = {
    writer
  }
}

trait HtmlWriter[A] {
  def write(in: A): String
}

object RockItImplicitly {

  def writePerson() = {
    // Type class instance
    implicit object PersonWriter extends HtmlWriter[Person] {
      def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
    }

    println(HtmlWriter[Person].write(Person("bill", "bAndb@flobalob.com")))
  }

  def writeApproximately() = {
    // Type class instance
    implicit object ApproximationWriter extends HtmlWriter[Int] {
      def write(in: Int): String =
        s"It's definitely less than ${((in / 10) + 1) * 10}"
    }

    println(HtmlWriter[Int].write(2))
  }

  def main(args: Array[String]): Unit = {
    writePerson()
    writeApproximately()
  }
}