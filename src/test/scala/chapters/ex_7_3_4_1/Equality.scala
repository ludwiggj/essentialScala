package chapters.ex_7_3_4_1

case class Person(name: String, email: String)

trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

// Type class instance
object StringEquals extends Equal[String] {
  override def equal(v1: String, v2: String): Boolean = v1 == v2
}

object PersonEqualsOnEmailAddress extends Equal[Person] {
  override def equal(v1: Person, v2: Person): Boolean = {
    v1.email == v2.email
  }
}

object PersonEqualsOnNameAndEmailAddress extends Equal[Person] {
  override def equal(v1: Person, v2: Person): Boolean = {
    v1.name == v2.name && v1.email == v2.email
  }
}

object DoIt {
  def main(args: Array[String]): Unit = {
    println(StringEquals.equal("a", "b"))
    println(StringEquals.equal("a", "a"))

    val p1 = Person("Bart", "bart@springfield.com")
    val p2 = Person("Lisa", "lisa@springfield.com")
    val p3 = Person("Homer", "bart@springfield.com")
    val p4 = Person("Lisa", "lisa@springfield.com")

    println(s"$p1 = $p2? [${PersonEqualsOnEmailAddress.equal(p1, p2)}]")
    println(s"$p1 = $p3? [${PersonEqualsOnEmailAddress.equal(p1, p3)}]")
    println(s"$p2 = $p4? [${PersonEqualsOnEmailAddress.equal(p2, p4)}]")

    println(s"$p1 = $p2? [${PersonEqualsOnNameAndEmailAddress.equal(p1, p2)}]")
    println(s"$p1 = $p3? [${PersonEqualsOnNameAndEmailAddress.equal(p1, p3)}]")
    println(s"$p2 = $p4? [${PersonEqualsOnNameAndEmailAddress.equal(p2, p4)}]")
  }
}
