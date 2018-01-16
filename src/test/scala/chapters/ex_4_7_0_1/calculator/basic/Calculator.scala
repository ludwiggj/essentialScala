package chapters.ex_4_7_0_1.calculator.basic

/*
We’re now going to work on a larger problem to implement a simple interpreter for programs containing only numeric
operations. We start by defining some types to represent the expressions we’ll be operating on. In the compiler
literature this is known as an abstract syntax tree.

Our representation is:
• An Expression is an Addition, Subtraction, or a Number;
• An Addition has a left and right Expression;
• A Subtraction has a left and right Expression; or
• A Number has a value of type Double.
Implement this in Scala.

Now implement a method eval that converts an Expression to a Double. Use polymorphism or pattern matching as
you see fit. Explain your choice of implementation method.

We’re now going to add some expressions that can fail: division and square root. Start by extending the abstract syntax
tree to include representations for Division and SquareRoot.

12.0.64
Now we’re going to change eval to represent that a computation can fail. (Double generally used NaN to indicate a
computation failed, but we want to be helpful to the user and tell them why the computation failed.) Implement an
appropriate algebraic data type.

12.0.65
Now change eval to return your result type, which I have called Calculation in my implementation. Here are some
examples:

assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval == Failure("Square root of negative number"))
assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
assert(Division(Number(4), Number(0).eval == Failure("Division by zero"))
 */

sealed trait Expression {
  def eval: Double = {
    this match {
      case Number(value: Double) => value
      case Addition(left: Expression, right: Expression) => left.eval + right.eval
      case Subtraction(left: Expression, right: Expression) => left.eval - right.eval
    }
  }
}

final case class Number(value: Double) extends Expression

final case class Addition(left: Expression, right: Expression) extends Expression

final case class Subtraction(left: Expression, right: Expression) extends Expression

object Calculator extends App {
  assert(Number(1.0).eval == 1.0)
  assert(Addition(Number(1.0), Number(2.4)).eval == 3.4)
  assert(Subtraction(Number(1.0), Number(2.4)).eval == -1.4)
}