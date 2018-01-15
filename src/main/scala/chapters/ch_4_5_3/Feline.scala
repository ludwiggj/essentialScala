package chapters.ch_4_5_3

sealed trait Food

final case object Antelope extends Food

final case object TigerFood extends Food

final case object Licorice extends Food

final case class CatFood(food: String) extends Food

sealed trait Feline {
  // dinner via polymorphism
  def dinner: Food

  // breakfast via pattern matching, version 1
  def breakfast: Food =
    this match {
      case Lion() => Antelope
      case Tiger() => TigerFood
      case Panther() => Licorice
      case Cat(favouriteFood) => CatFood(favouriteFood)
    }
}

final case class Lion() extends Feline {
  def dinner: Food = Antelope
}

final case class Tiger() extends Feline {
  def dinner: Food = TigerFood
}

final case class Panther() extends Feline {
  def dinner: Food = Licorice
}

final case class Cat(favouriteFood: String) extends Feline {
  def dinner: Food = CatFood(favouriteFood)
}

object Diner {
  // elevensies via pattern matching, version 2
  def elevensies(feline: Feline): Food =
    feline match {
      case Lion() => Antelope
      case Tiger() => TigerFood
      case Panther() => Licorice
      case Cat(food) => CatFood(food)
    }
}