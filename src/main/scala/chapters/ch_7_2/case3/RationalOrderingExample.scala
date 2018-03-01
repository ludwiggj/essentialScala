package chapters.ch_7_2.case3

final case class Rational(numerator: Int, denominator: Int)

// When defining a type class instance, if
// 1. there is a single instance for the type; and
// 2. you can edit the code for the type that you are defining the instance for
// then define the type class instance in the companion object of the type.
object Rational {
  def asDouble(r: Rational) = {
    r.numerator.toDouble / r.denominator
  }

  implicit val rationalOrdering = Ordering.fromLessThan[Rational](
    asDouble(_) < asDouble(_)
  )
}

object RationalOrderingExample {

  // This works, as implicit ordering is in the Rational companion object, and therefore is in scope
  def main(args: Array[String]): Unit = {

    def example = {
      assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
        List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
    }

    example
  }
}