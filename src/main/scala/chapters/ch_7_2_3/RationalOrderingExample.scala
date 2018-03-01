package chapters.ch_7_2_3

final case class Rational(numerator: Int, denominator: Int)

// If there is no good default instance for a type class instance, or if there are several
// good defaults, we should not place an type class instances in the companion object but
// instead require the user to explicitly import an instance into the local scope.

// In this case, one simple way to package instances is to place each in its own object that
// the user can import into the local scope. For instance, we might define orderings for Rational
// as follows
object Rational {
  def asDouble(r: Rational) = {
    r.numerator.toDouble / r.denominator
  }
}

object RationalLessThanOrdering {
  import Rational.asDouble

  implicit val ordering = Ordering.fromLessThan[Rational](
    asDouble(_) < asDouble(_)
  )
}

object RationalGreaterThanOrdering {
  import Rational.asDouble

  implicit val ordering = Ordering.fromLessThan[Rational](
    asDouble(_) > asDouble(_)
  )
}

object RationalOrderingExample {
  def main(args: Array[String]): Unit = {

    def exampleLessThan = {
      import RationalLessThanOrdering.ordering

      assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
        List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
    }

    def exampleGreaterThan = {
      import RationalGreaterThanOrdering.ordering

      assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
        List(Rational(3, 4), Rational(1, 2), Rational(1, 3)))
    }

    exampleLessThan
    exampleGreaterThan
  }
}