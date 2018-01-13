package chapters.ex_3_1_6_1

class Cat(val name: String, val colour: String, val food: String)

object Main extends App {
  val oswald = new Cat("Oswald", "Black", "Milk")
  val henderson = new Cat("Henderson", "Ginger", "Chips")
  val quentin = new Cat("Quentin", "Tabby and white", "Curry")
}
