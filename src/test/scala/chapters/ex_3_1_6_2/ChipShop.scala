package chapters.ex_3_1_6_2

import chapters.ex_3_1_6_1.Cat

object ChipShop {
  def willServe(c: Cat) = {
    c.food == "Chips"
  }
}

object Main extends App {
  val oswald = new Cat("Oswald", "Black", "Milk")
  val henderson = new Cat("Henderson", "Ginger", "Chips")
  val quentin = new Cat("Quentin", "Tabby and white", "Curry")

  println(ChipShop.willServe(oswald))
  println(ChipShop.willServe(henderson))
  println(ChipShop.willServe(quentin))
}