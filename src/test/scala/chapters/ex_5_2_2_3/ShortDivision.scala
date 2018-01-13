package chapters.ex_5_2_2_3

/*
Good Scala developers don’t just use types to model data. Types are a great way to put artificial limitations in place
to ensure we don’t make mistakes in our programs. In this exercise we will see a simple (if contrived) example of this,
using types to prevent division by zero errors.

Dividing by zero is a tricky problem—it can lead to exceptions. The JVM has us covered as far as floating point division
is concerned but integer division is still a problem:

scala> 1.0 / 0.0
res0: Double = Infinity

scala> 1 / 0
java.lang.ArithmeticException: / by zero

Let’s solve this problem once and for all using types!

Create an object called divide with an apply method that accepts two Ints and returns DivisionResult.

DivisionResult should be a sealed trait with two subtypes: a Finite type encapsulating the result of a valid
Division and an Infinite type representing the result of dividing by 0.

Here’s some example usage:

scala> divide(1, 2)

res7: DivisionResult = Finite(0)

scala> divide(1, 0)

res8: DivisionResult = Infinite

Finally, write a sample function that calls divide, matches on the result, and returns a sensible description.

*/

object Divide {
  def apply(number: Int, divisor: Int): DivisionResult = divisor match {
    case 0 => Infinite()
    case _ => Finite(number/divisor)
  }
}

sealed trait DivisionResult

final case class Finite(value: Int) extends DivisionResult
final case class Infinite() extends DivisionResult

object mathsMachine extends App {
  def doDivision(number: Int, divisor: Int) {
    val result = Divide(number, divisor) match {
      case Finite(result) => result.toString
      case Infinite() => "Infinity"
    }

    println(s"$number divided by $divisor = $result")
  }

  doDivision(1, 2)
  doDivision(1, 0)
  doDivision(6, 4)
  doDivision(28, 3)
}