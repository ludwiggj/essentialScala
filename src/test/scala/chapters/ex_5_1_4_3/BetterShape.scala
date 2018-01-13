package chapters.ex_5_1_4_3

import chapters.ex_5_1_4_2.Shape

/*
The solution from the last exercise delivered three distinct types of shape. However, it doesn’t model
the relationships between the three correctly. A Square isn’t just a Shape—it’s also a type of Rectangle
where the width and height are the same. Refactor the solution to the last exercise so that Square and
Rectangle are subtypes of a common type Rectangular.

Tip: A trait can extend another trait.
 */

trait Rectangular extends Shape {

  override def sides: Int = 4

  def width: Double

  def height: Double

  override def perimeter: Double = 2 * width + 2 * height

  override def area: Double = width * height
}

case class BetterRectangle(width: Double, height: Double) extends Rectangular

case class BetterSquare(side: Double) extends Rectangular {
  override val width = side
  override val height = side
}

object BetterShapery extends App {
  def getDetails(shape: Shape) = {
    s"Sides ${shape.sides} Perimeter ${shape.perimeter} Area ${shape.area}"
  }

  private val rectangle = BetterRectangle(2, 3)
  println(s"Rectangle, ${rectangle.width} x ${rectangle.height}, [${getDetails(rectangle)}]")

  private val square = BetterSquare(5)
  println(s"Square, ${square.side} x ${square.side}, [${getDetails(square)}]")
}