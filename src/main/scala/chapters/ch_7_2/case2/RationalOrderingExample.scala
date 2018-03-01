package chapters.ch_7_2.case2

final case class Rational(numerator: Int, denominator: Int)

object Instance {
  def asDouble(r: Rational) = {
    r.numerator.toDouble / r.denominator
  }

  implicit val rationalOrdering = Ordering.fromLessThan[Rational](
    asDouble(_) < asDouble(_)
  )
}

object RationalOrderingExample {

  // This does not work, as implicit ordering is not in scope
  def main(args: Array[String]): Unit = {

    def example = {

      // Commented out as otherwise cannot run other examples
//      assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
//        List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
    }

    example
  }
}