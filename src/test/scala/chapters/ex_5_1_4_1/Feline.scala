package chapters.ex_5_1_4_1

/*
Demand for Cat Simulator 1.0 is exploding! For v2 we’re going to go beyond the domestic cat to model Tigers, Lions,
and Panthers in additonal to the Cat. Define a trait Feline and then define all the different species as subtypes of
Feline. To make things interesting, define:

• on Feline a colour as before;
• on Feline a String sound, which for a cat is "meow" and is "roar" for all other felines;
• only Cat has a favourite food; and
• Lions have an Int maneSize.

*/

trait Feline {
  def colour: String
  def sound: String = "roar"

  override def toString = s"Colour $colour, Sound $sound"
}

case class Cat(colour: String, favouriteFood: String, override val sound: String = "meow")
  extends Feline {

  override def toString = super.toString + s", FavouriteFood $favouriteFood"
}

case class Tiger(colour: String = "yellow and black") extends Feline

case class Lion(colour: String = "sandy", maneSize: Int) extends Feline {
  override def toString = super.toString + s", ManeSize $maneSize"
}

object Cattery extends App {
  println(Cat("ginger", "fish"))
  println(Tiger())
  println(Lion(maneSize = 2))
}