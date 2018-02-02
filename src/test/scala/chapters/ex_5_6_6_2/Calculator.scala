package chapters.ex_5_6_6_2

sealed trait Expression {

  private def lift(left: Expression, right: Expression, f: (Double, Double) => Sum[String, Double]) = {
    left.eval flatMap {
      l =>
        right.eval flatMap {
          r => f(l, r)
        }
    }
  }


  def eval: Sum[String, Double] = {
    this match {
      case Number(value: Double) => Success(value)

      case Addition(left: Expression, right: Expression) =>
        lift(left, right, (x, y) => Success(x + y))

      case Subtraction(left: Expression, right: Expression) =>
        lift(left, right, (x, y) => Success(x - y))

      case SquareRoot(value: Expression) => value.eval flatMap {
        v => if (v >= 0.0) Success(Math.sqrt(v)) else Failure("Square root of negative number")
      }

      case Division(left: Expression, right: Expression) =>
        lift(left, right, (x, y) => if (y == 0) Failure("Division by zero") else Success(x / y))
    }
  }
}

final case class Addition(left: Expression, right: Expression) extends Expression

final case class Subtraction(left: Expression, right: Expression) extends Expression

final case class Division(numerator: Expression, denominator: Expression) extends Expression

final case class SquareRoot(value: Expression) extends Expression

final case class Number(value: Double) extends Expression

object Calculator extends App {
  assert(Number(1.0).eval == Success(1.0))
  assert(Addition(Number(1.0), Number(2.4)).eval == Success(3.4))
  assert(Subtraction(Number(1.0), Number(2.4)).eval == Success(-1.4))
  assert(SquareRoot(Number(9.0)).eval == Success(3.0))
  assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval == Failure("Square root of negative number"))
  assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
  assert(Division(Number(1.0), Number(2.0)).eval == Success(0.5))
  assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
}