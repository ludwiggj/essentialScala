package chapters.ex_3_5_3_1

import chapters.ex_3_4_5_1.Cat

object ChipShop {
  def willServe(c: Cat) = {
    c match {
      case Cat(_, _, "Chips") => true
      case _ => false
    }
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