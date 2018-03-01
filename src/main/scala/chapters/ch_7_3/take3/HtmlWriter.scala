package chapters.ch_7_3.take3

import java.util.Date

import chapters.ch_7_3.Person

// Use an adapter class (the type class)
trait HtmlWriter[A] {
  def write(in: A): String
}

// Type class instance
object PersonWriter extends HtmlWriter[Person] {
  def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
}

// Type class instance
object DateWriter extends HtmlWriter[Date] {
  override def write(in: Date): String = s"<span>${in.toString}</span>"
}

// Type class instance
object ObfuscatedPersonWriter extends HtmlWriter[Person] {
  override def write(person: Person): String = s"<span>${person.name} (${person.email.replaceAll("@", " at ")})</span>"
}

object DoIt {
  def main(args: Array[String]): Unit = {
    println(PersonWriter.write(Person("bill", "bAndb@flobalob.com")))
    println(DateWriter.write(new Date()))
    println(ObfuscatedPersonWriter.write(Person("bill", "bAndb@flobalob.com")))
  }
}
