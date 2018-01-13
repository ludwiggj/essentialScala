package chapters.ex_5_1_4_2

/*
Define a trait called Shape and give it three abstract methods:

• sides returns the number of sides;
• perimeter returns the total length of the sides;
• area returns the area.

Implement Shape with three classes: Circle, Rectangle, and Square. In each case provide implementations of each of
the three methods. Ensure that the main constructor parameters of each shape (e.g. the radius of the circle) are
accessible as fields.

Tip: The value of π is accessible as math.Pi.
 */
trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

case class Circle(radius: Double) extends Shape {
  override def sides: Int = 1

  override def perimeter: Double = Math.PI * 2 * radius

  override def area: Double = Math.PI * radius * radius
}

case class Rectangle(width: Double, height: Double) extends Shape {
  override def sides: Int = 4

  override def perimeter: Double = 2 * width + 2 * height

  override def area: Double = width * height
}

case class Square(side: Double) extends Shape {
  override def sides: Int = 4

  override def perimeter: Double = 4 * side

  override def area: Double = side * side
}

object Shapery extends App {
  def getDetails(shape: Shape) = {
    s"Sides ${shape.sides} Perimeter ${shape.perimeter} Area ${shape.area}"
  }

  private val circle = Circle(1)
  println(s"Circle, radius ${circle.radius}, [${getDetails(circle)}]")

  private val rectangle = Rectangle(2, 3)
  println(s"Rectangle, ${rectangle.width} x ${rectangle.height}, [${getDetails(rectangle)}]")

  private val square = Square(5)
  println(s"Square, ${square.side} x ${square.side}, [${getDetails(square)}]")
}
