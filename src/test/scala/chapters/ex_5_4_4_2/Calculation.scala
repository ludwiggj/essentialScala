package chapters.ex_5_4_4_2

/*
    A calculation may succeed (with an Int result) or fail (with a String message). Implement this.
 */

sealed trait Calculation

final case class CalculationSuccess(result: Int) extends Calculation
final case class CalculationFailure(message: String) extends Calculation