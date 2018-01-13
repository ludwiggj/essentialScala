package chapters.ex_3_4_5_4

case class Person(val firstName: String, val lastName: String) {
  def name = s"$firstName $lastName"
}

object Person {
  def apply(name: String) = {
    val nameParts = name.split(" ")
    new Person(nameParts(0), nameParts(1))
  }
}

object Peeps extends App {
  println(Person("Graeme Ludwig").name)
  println(Person("Mister Bean").name)
}