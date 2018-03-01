package chapters.ch_7_2_2

final case class Rational(numerator: Int, denominator: Int)

object Rational {
  def asDouble(r: Rational) = {
    r.numerator.toDouble / r.denominator
  }

  implicit val ordering = Ordering.fromLessThan[Rational](
    asDouble(_) < asDouble(_)
  )
}

object RationalOrderingExample {

  import chapters.ch_7_2_2.Rational.asDouble

  // This implicit ordering takes priority
  implicit val higherPriorityImplicit = Ordering.fromLessThan[Rational](
    asDouble(_) > asDouble(_)
  )

  // Type Class Instance Packaging: Companion Objects Part 2
  // When defining a type class instance, if
  //
  //  1. there is a single good default instance for the type; and
  //  2. you can edit the code for the type that you are defining the instance for
  //
  //  then define the type class instance in the companion object of the type. This
  // allows users to override the instance by defining one in the local scope whilst
  // still providing sensible default behaviour.
  def main(args: Array[String]): Unit = {

    def example = {
      assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
        List(Rational(3, 4), Rational(1, 2), Rational(1, 3)))
    }

    example
  }
}