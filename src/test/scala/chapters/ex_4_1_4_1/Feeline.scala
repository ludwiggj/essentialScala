package chapters.ex_4_1_4_1

trait Feeline {
  def colour: String
  def sound: String

  override def toString = s"Colour $colour, Sound $sound"
}

trait BigCat extends Feeline {
  override val sound: String = "Roar"
}

case class Catz(colour: String, favouriteFood: String, override val sound: String = "meow") extends Feeline {
  override def toString = super.toString + s", FavouriteFood $favouriteFood"
}

case class Tigerz(colour: String = "yellow and black") extends BigCat

case class Lionz(colour: String = "sandy", maneSize: Int) extends BigCat {
  override def toString = super.toString + s", ManeSize $maneSize"
}

object Zoo extends App {
  println(Catz("ginger", "fish"))
  println(Tigerz())
  println(Lionz(maneSize = 2))
}