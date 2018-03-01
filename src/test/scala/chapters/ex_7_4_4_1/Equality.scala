package chapters.ex_7_4_4_1

case class Person(name: String, email: String)

object Eq {
  def apply[A](in1: A, in2: A)(implicit equals: Equal[A]): Boolean = {
    equals.equal(in1, in2)
  }
}

trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

object Equal {
  def apply[A](implicit eq: Equal[A]): Equal[A] = eq
}

object EmailImplicit {
  implicit object EmailEqual extends Equal[Person] {
    override def equal(v1: Person, v2: Person): Boolean = {
      v1.email == v2.email
    }
  }
}

object NameAndEmailImplicit {
  implicit object NameEmailEqual extends Equal[Person] {
    override def equal(v1: Person, v2: Person): Boolean = {
      v1.name == v2.name && v1.email == v2.email
    }
  }
}

object DoItImplicitlyByTheBook {

  val p1 = Person("Bart", "bart@springfield.com")
  val p2 = Person("Lisa", "lisa@springfield.com")
  val p3 = Person("Homer", "bart@springfield.com")
  val p4 = Person("Lisa", "lisa@springfield.com")

  def testOnEmailAddress() = {
    import EmailImplicit._

    println(s"$p1 = $p2? [${Eq(p1, p2)}]")
    println(s"$p1 = $p3? [${Eq(p1, p3)}]")
    println(s"$p2 = $p4? [${Eq(p2, p4)}]")
  }

  def testOnEmailAddress2() = {
    import EmailImplicit._

    println(s"$p1 = $p2? [${Equal[Person].equal(p1, p2)}]")
    println(s"$p1 = $p3? [${Equal[Person].equal(p1, p3)}]")
    println(s"$p2 = $p4? [${Equal[Person].equal(p2, p4)}]")
  }

  def testOnNameAndEmailAddress() = {
    import NameAndEmailImplicit._

    println(s"$p1 = $p2? [${Eq(p1, p2)}]")
    println(s"$p1 = $p3? [${Eq(p1, p3)}]")
    println(s"$p2 = $p4? [${Eq(p2, p4)}]")
  }

  def testOnNameAndEmailAddress2() = {
    import NameAndEmailImplicit._

    println(s"$p1 = $p2? [${Equal[Person].equal(p1, p2)}]")
    println(s"$p1 = $p3? [${Equal[Person].equal(p1, p3)}]")
    println(s"$p2 = $p4? [${Equal[Person].equal(p2, p4)}]")
  }

  def main(args: Array[String]): Unit = {
    testOnEmailAddress()
    testOnNameAndEmailAddress()
    testOnEmailAddress2()
    testOnNameAndEmailAddress2()
  }
}