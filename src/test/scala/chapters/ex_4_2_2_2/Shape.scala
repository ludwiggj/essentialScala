package chapters.ex_4_2_2_2

/*
Let’s revisit the Shapes example from the previous section.

First make Shape a sealed trait. Then write a singleton object called Draw with an apply method that takes a Shape as an
argument and returns a description of it on the console. For example:

Draw(Circle(10)) // returns "A circle of radius 10cm"
Draw(Rectangle(3, 4)) // returns "A rectangle of width 3cm and height 4cm"

and so on...

Finally, verify that the compiler complains when you comment out a case clause.

Edit the code for Shape and its subtypes to add a colour to each shape.

Finally, update the code for Draw.apply to print the colour of the argument as well as its shape and dimensions:

• if the argument is a predefined colour, print that colour by name:

  Draw(Circle(10, Yellow)) // returns "A yellow square of size 10cm"

• if the argument is a custom colour rather than a predefined one, print the word “light” or “dark” instead.

You may want to deal with the colour in a helper method.
*/

sealed trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double

  def colour: Colour
}

trait Rectangular extends Shape {

  val sides = 4

  def width: Double

  def height: Double

  val perimeter = 2 * width + 2 * height
  val area = width * height
}

final case class Rectangle(width: Double, height: Double, colour: Colour) extends Rectangular

final case class Square(side: Double, colour: Colour) extends Rectangular {
  val width = side
  val height = side
}

case class Circle(radius: Double, colour: Colour) extends Shape {
  val sides = 1
  val perimeter = Math.PI * 2 * radius
  val area = Math.PI * radius * radius
}

object Draw {
  def apply(shape: Shape): Unit = {

    // NB If use Rectangle instead of Rectangular then compiler will warn of missing case class
    val description = shape match {
      case Square(side: Double, colour: Colour) => s"A ${Draw(colour)} square of side $side cm"
      case (r: Rectangular) => s"A ${Draw(r.colour)} rectangle of width ${r.width} cm and height ${r.height} cm"
      case Circle(radius, colour) => s"A ${Draw(colour)} circle of radius ${radius} cm"
    }

    println(description)
  }

  def apply(colour: Colour): String = {
    colour match {
      case Red => "red"
      case Yellow => "yellow"
      case Pink => "pink"
      case cc: CustomColour => cc.lightOrDark
    }
  }
}

object Shapery extends App {
  Draw(Circle(4, Pink))
  Draw(Rectangle(2, 3, Red))
  Draw(Square(5, CustomColour(255, 255, 255)))
}