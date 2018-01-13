package chapters.ex_3_4_5_1

case class Cat(name: String, colour: String, food: String)

object Main extends App {
  val oswald = Cat("Oswald", "Black", "Milk")
  val henderson = Cat("Henderson", "Ginger", "Chips")
  val quentin = Cat("Quentin", "Tabby and white", "Curry")
}