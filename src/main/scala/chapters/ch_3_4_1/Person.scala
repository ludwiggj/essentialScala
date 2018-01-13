package chapters.ch_3_4_1

case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

object Workout extends App {
  val dave = new Person("Dave", "Gurnell")

  println(Person)
  println(dave.firstName)
  println(dave)
  println(new Person("Noel", "Welsh").equals(new Person("Noel", "Welsh")))
  println(new Person("Noel", "Welsh") == new Person("Noel", "Welsh"))
  println(dave.copy() eq dave)
  println(dave.copy(firstName = "Dave2"))
  println(dave.copy(lastName = "Gurnell2"))
  println(new Person("Noel", "Welsh") eq (new Person("Noel", "Welsh")))
  println(dave eq dave)

  println(Person("Dave", "Gurnell") == Person("Noel", "Welsh"))
  println(Person("Dave", "Gurnell") == Person("Dave", "Gurnell"))
}