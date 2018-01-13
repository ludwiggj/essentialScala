package chapters.ex_5_5_6_2

/*
    A calculation may succeed (with an Int result) or fail (with a String message). Implement this.

    Create a Calculator object. On Calculator define methods + and - that accept a Calculation and an Int, and return
    a new Calculation. Here are some examples
    assert(Calculator.+(Success(1), 1) == Success(2))
    assert(Calculator.-(Success(1), 1) == Success(0))
    assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))
 */

sealed trait Calculation

final case class Success(result: Int) extends Calculation
final case class Failure(message: String) extends Calculation

object Calculator extends App {
  def +(calculation: Calculation, value: Int) = {
    calculation match {
      case Success(totalSoFar) => Success(totalSoFar + value)
      case f: Failure => f
    }
  }

  def -(calculation: Calculation, value: Int) = {
    calculation match {
      case Success(totalSoFar) => Success(totalSoFar - value)
      case f: Failure => f
    }
  }

  private val calculation1 = Calculator.+(Success(1), 1)
  assert(calculation1 == Success(2))
  println(calculation1)

  private val calculation2 = Calculator.-(Success(1), 1)
  assert(calculation2 == Success(0))
  println(calculation2)

  private val calculation3 = Calculator.+(Failure("Badness"), 1)
  assert(calculation3 == Failure("Badness"))
  println(calculation3)
}