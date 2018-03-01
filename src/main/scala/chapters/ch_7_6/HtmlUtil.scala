package chapters.ch_7_6

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

// Magic! See later for explanation....
object HtmlImplicit {

  implicit class HtmlOps[T](data: T) {
    def toHtml(implicit writer: HtmlWriter[T]) =
      writer.write(data)
  }

}

object RockItImplicitly {
  def writePerson() = {
    // Type class instance
    implicit object PersonWriter extends HtmlWriter[Person] {
      def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
    }

    // So far we have used:

    // println(HtmlWriter[Person].write(Person("bill", "bAndb@flobalob.com")))

    // Now want to make this even simpler, to wit:
    // println(Person("John", "john@example.com").toHtml)

    // Add an implicit class with a method that itself defines an implicit parameter, HtmlOps
    // Defined in outer scope above so it can be reused

    import HtmlImplicit._

    // We can now invoke our type-class pattern (i.e. toHtml method) on any type for which we have an adapter, as if
    // it were a built-in feature of the class:

    println(Person("John", "john@example.com").toHtml)
  }

  def writeApproximately() = {
    // Type class instance
    implicit object ApproximationWriter extends HtmlWriter[Int] {
      def write(in: Int): String =
        s"It's definitely less than ${((in / 10) + 1) * 10}"
    }

    // println(HtmlWriter[Int].write(2))

    import HtmlImplicit._

    println(2.toHtml)
  }

  def main(args: Array[String]): Unit = {
    writePerson()
    writeApproximately()
  }
}