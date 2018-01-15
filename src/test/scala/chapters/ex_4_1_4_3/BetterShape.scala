package chapters.ex_4_1_4_3

import chapters.ex_4_1_4_2.Shape

/*
The solution from the last exercise delivered three distinct types of shape. However, it doesn't model
the relationships between the three correctly. A Square isn't just a Shape - it's also a type of Rectangle
where the width and height are the same. Refactor the solution to the last exercise so that Square and
Rectangle are subtypes of a common type Rectangular.

Tip: A trait can extend another trait.
 */

trait Rectangular extends Shape {
  val sides = 4
  def width: Double
  def height: Double
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

case class BetterRectangle(width: Double, height: Double) extends Rectangular

case class BetterSquare(side: Double) extends Rectangular {
  override val width = side
  override val height = side
}

object BetterShapery extends App {
  private val rectangle = BetterRectangle(2, 3)
  println(s"Rectangle, ${rectangle.width} x ${rectangle.height}, [$rectangle]")

  private val square = BetterSquare(5)
  println(s"Square, ${square.side} x ${square.side}, [$square]")
}