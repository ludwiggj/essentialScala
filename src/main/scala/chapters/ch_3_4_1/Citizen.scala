package chapters.ch_3_4_1

// The case object keyword defines a class and an object, and makes the object an instance (actually the only instance)
// of the class

case object Citizen {
  def firstName = "John"
  def lastName = "Doe"
  def name = firstName + " " + lastName
}