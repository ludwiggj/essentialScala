package chapters.ex_3_4_5_2

case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
  def name = s"$firstName $lastName"
}

object Director {
  def older(d1: Director, d2: Director) = {
    if (d1.yearOfBirth >= d2.yearOfBirth) d1 else d2
  }
}