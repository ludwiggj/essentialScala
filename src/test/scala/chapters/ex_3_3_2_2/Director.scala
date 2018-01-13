package chapters.ex_3_3_2_2

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name = s"$firstName $lastName"

  override def toString: String = s"Director($name, $yearOfBirth)"
}

object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int) = {
    new Director(firstName, lastName, yearOfBirth)
  }

  def older(d1: Director, d2: Director) = {
    if (d1.yearOfBirth >= d2.yearOfBirth) d1 else d2
  }
}