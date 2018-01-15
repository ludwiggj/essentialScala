package chapters.ex_4_5_6_2

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
  def +(calculation: Calculation, value: Int): Calculation = {
    calculation match {
      case Success(totalSoFar) => Success(totalSoFar + value)
      case f: Failure => f
    }
  }

  def -(calculation: Calculation, value: Int): Calculation = {
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

  // Now write a division method that fails if the divisor is 0. The following tests should pass.
  // Note the behavior for the last test. This indicates “fail fast” behavior. If a calculation has already failed
  // we keep that failure and don’t process any more data even if, as is the case in the test, doing so would lead
  // to another failure.

  def /(calculation: Calculation, value: Int): Calculation = {
    calculation match {
      case Success(totalSoFar) => if (value != 0) Success(totalSoFar / value) else Failure("Division by zero")
      case f: Failure => f
    }
  }

  private val calculation4 = Calculator./(Success(4), 2)
  assert(calculation4 == Success(2))
  println(calculation4)

  private val calculation5: Calculation = Calculator./(Success(4), 0)
  assert(calculation5 == Failure("Division by zero"))
  println(calculation5)

  private val calculation6: Calculation = Calculator./(Failure("Badness"), 0)
  assert(calculation6 == Failure("Badness"))
  println(calculation6)
}