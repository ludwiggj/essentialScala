package chapters.ex_4_2_2_1

/*
Let’s revisit the Shapes example from the previous section.

First make Shape a sealed trait. Then write a singleton object called Draw with an apply method that takes a Shape as an
argument and returns a description of it on the console. For example:

Draw(Circle(10)) // returns "A circle of radius 10cm"
Draw(Rectangle(3, 4)) // returns "A rectangle of width 3cm and height 4cm"

and so on...

Finally, verify that the compiler complains when you comment out a case clause.
*/

sealed trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

trait Rectangular extends Shape {

  val sides = 4

  def width: Double

  def height: Double

  val perimeter = 2 * width + 2 * height
  val area = width * height
}

case class Rectangle(width: Double, height: Double) extends Rectangular

case class Square(side: Double) extends Rectangular {
  val width = side
  val height = side
}

case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = Math.PI * 2 * radius
  val area = Math.PI * radius * radius
}

object Draw {
  def apply(shape: Shape) = {

    // If use Rectangle instead of Rectangular then compiler will warn of missing case class
    val description = shape match {
      case (s: Square) => s"A square of side ${s.side} cm"
      case (r: Rectangle) => s"A rectangle of width ${r.width} cm and height ${r.height} cm"
      case (c: Circle) => s"A circle of radius ${c.radius} cm"
    }

    println(description)
  }
}

object Shapery extends App {
  Draw(Circle(4))
  Draw(Rectangle(2, 3))
  Draw(Square(5))
}