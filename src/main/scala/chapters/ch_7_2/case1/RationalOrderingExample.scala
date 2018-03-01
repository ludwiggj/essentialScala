package chapters.ch_7_2.case1

final case class Rational(numerator: Int, denominator: Int)

object RationalOrderingExample {

  // This works fine, implicit ordering is in scope
  def main(args: Array[String]): Unit = {

    def example = {
      def asDouble(r: Rational) = {
        r.numerator.toDouble / r.denominator
      }

      implicit val rationalOrdering = Ordering.fromLessThan[Rational](
        asDouble(_) < asDouble(_)
      )

      assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
        List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
    }

    example
  }
}