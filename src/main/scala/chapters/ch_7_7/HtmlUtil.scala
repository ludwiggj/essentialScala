package chapters.ch_7_7

import chapters.ch_7_3.Person

// Type class interface pattern
object HtmlWriter {
  def apply[A : HtmlWriter]: HtmlWriter[A] = {
    implicitly[HtmlWriter[A]]
  }
}

trait HtmlWriter[A] {
  def write(in: A): String
}

// Magic! See later for explanation....
object HtmlImplicit {

  implicit class HtmlOps[T : HtmlWriter](data: T) {
    def toHtml = implicitly[HtmlWriter[T]].write(data)
  }
}

object RockItAgainImplicitly {
  def writePerson() = {
    // Type class instance
    implicit object PersonWriter extends HtmlWriter[Person] {
      def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
    }

    println(HtmlWriter[Person].write(Person("bill", "bAndb@flobalob.com")))

    import HtmlImplicit._

    println(Person("John", "john@example.com").toHtml)
  }

  def writeApproximately() = {
    // Type class instance
    implicit object ApproximationWriter extends HtmlWriter[Int] {
      def write(in: Int): String =
        s"It's definitely less than ${((in / 10) + 1) * 10}"
    }

    println(HtmlWriter[Int].write(20))

    import HtmlImplicit._

    println(2.toHtml)
  }

  def main(args: Array[String]): Unit = {
    writePerson()
    writeApproximately()
  }
}