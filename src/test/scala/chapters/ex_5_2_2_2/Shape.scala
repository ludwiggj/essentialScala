package chapters.ex_5_2_2_2

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

  override def sides: Int = 4

  def width: Double

  def height: Double

  override def perimeter: Double = 2 * width + 2 * height

  override def area: Double = width * height
}

final case class Rectangle(width: Double, height: Double, colour: Colour) extends Rectangular {
}

final case class Square(side: Double, colour: Colour) extends Rectangular {
  override val width = side
  override val height = side
}

case class Circle(radius: Double, colour: Colour) extends Shape {
  override def sides: Int = 1

  override def perimeter: Double = Math.PI * 2 * radius

  override def area: Double = Math.PI * radius * radius
}

object Draw {
  def apply(shape: Shape) = {

    // NB If use Rectangle instead of Rectangular then compiler will warn of missing case class
    val description = shape match {
      case (s: Square) => s"A ${getDescription(shape.colour)} square of side ${s.side} cm"
      case (r: Rectangular) => s"A ${getDescription(shape.colour)} rectangle of width ${r.width} cm and height ${r.height} cm"
      case (c: Circle) => s"A ${getDescription(shape.colour)} circle of radius ${c.radius} cm"
    }

    println(description)
  }

  def getDescription(c: Colour): String = {
    c.name match {
      case Colour.CustomColourName => c.lightOrDark
      case _ => c.name
    }
  }
}

object Shapery extends App {
  Draw(Circle(4, Pink()))
  Draw(Rectangle(2, 3, Red()))
  Draw(Square(5, CustomColour(255, 255, 255)))
}