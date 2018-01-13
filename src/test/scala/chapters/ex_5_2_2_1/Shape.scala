package chapters.ex_5_2_2_1

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

  override def sides: Int = 4

  def width: Double

  def height: Double

  override def perimeter: Double = 2 * width + 2 * height

  override def area: Double = width * height
}

case class Rectangle(width: Double, height: Double) extends Rectangular

case class Square(side: Double) extends Rectangular {
  override val width = side
  override val height = side
}

case class Circle(radius: Double) extends Shape {
  override def sides: Int = 1

  override def perimeter: Double = Math.PI * 2 * radius

  override def area: Double = Math.PI * radius * radius
}

object Draw {
  def apply(shape: Shape) = {

    // NB If use Rectangle instead of Rectangular then ncompiler will warn of missing case class
    val description = shape match {
      case (s: Square) => s"A square of side ${s.side} cm"
      case (r: Rectangular) => s"A rectangle of width ${r.width} cm and height ${r.height} cm"
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