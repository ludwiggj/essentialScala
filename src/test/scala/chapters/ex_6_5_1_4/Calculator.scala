package chapters.ex_6_5_1_4

object Calculator extends App {

  def readInt(str: String): Option[Int] =
    if (str matches "\\d+") Some(str.toInt) else None

  def calculator(operand1: String, operator: String, operand2: String): Unit = {
    val result = for {
      op1 <- readInt(operand1)
      op2 <- readInt(operand2)
      res <- operator match {
        case "+" => Some(op1 + op2)
        case "-" => Some(op1 - op2)
        case "*" => Some(op1 * op2)
        case "/" => if (op2 != 0) Some(op1 / op2) else None
        case _  => None
      }
    } yield res

    result match {
      case Some(v) => println(s"Result is $v")
      case None => println("Could not calculate result")
    }
  }

  calculator("5", "+", "7")
  calculator("five", "+", "7")
  calculator("5", "-", "7")
  calculator("five", "-", "7")
  calculator("5", "*", "7")
  calculator("5", "*", "seven")
  calculator("14", "/", "7")
  calculator("14", "/", "0")
  calculator("5", "/", "seven")
  calculator("5", "^^", "2")
}
