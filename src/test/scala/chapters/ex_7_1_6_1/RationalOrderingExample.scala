package chapters.ex_7_1_6_1

object RationalOrderingExample {

  final case class Rational(numerator: Int, denominator: Int)

  def main(args: Array[String]): Unit = {

    def asDouble(r: Rational) = {
      r.numerator.toDouble / r.denominator
    }

    implicit val rationalOrdering = Ordering.fromLessThan[Rational](
      asDouble(_) < asDouble(_)
    )

    assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
      List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
  }
}