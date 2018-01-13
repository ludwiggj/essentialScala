package chapters.ex_3_1_6_3

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name = s"$firstName $lastName"

  override def toString: String = s"Director($name, $yearOfBirth)"
}
