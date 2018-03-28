package chapters.ch_7_6.experiment

import chapters.ch_7_3.Person

// This isn't needed once we have the implicit class in place...

// Type class interface pattern
//object HtmlWriter {
//  def apply[A](implicit writer: HtmlWriter[A]): HtmlWriter[A] = {
//    writer
//  }
//}

trait HtmlWriter[A] {
  def write(in: A): String
}

object HtmlImplicit {
  implicit class HtmlOps[T](data: T) {
    def toHtml(implicit writer: HtmlWriter[T]) =
      writer.write(data)
  }
}

object HtmlUtilExperiment {
  def writePerson() = {
    // Type class instance
    implicit object PersonWriter extends HtmlWriter[Person] {
      def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
    }

    import HtmlImplicit._

    println(Person("Johnny Boy", "john@example.com").toHtml)
  }

  def writeApproximately() = {
    // Type class instance
    implicit object ApproximationWriter extends HtmlWriter[Int] {
      def write(in: Int): String =
        s"It's definitely less than ${((in / 8) + 1) * 8}"
    }

    import HtmlImplicit._

    println(2.toHtml)
  }

  def main(args: Array[String]): Unit = {
    writePerson()
    writeApproximately()
  }
}