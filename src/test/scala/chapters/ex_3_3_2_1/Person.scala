package chapters.ex_3_3_2_1

class Person(val firstName: String, val lastName: String) {
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
}