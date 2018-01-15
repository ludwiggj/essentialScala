package chapters.ex_4_1_4_2

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

  override def toString = s"Sides $sides Perimeter $perimeter Area $area"
}

case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = Math.PI * 2 * radius
  val area = Math.PI * radius * radius
}

case class Rectangle(width: Double, height: Double) extends Shape {
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

case class Square(side: Double) extends Shape {
  val sides = 4
  val perimeter = 4 * side
  val area = side * side
}

object Shapery extends App {
  private val circle = Circle(1)
  println(s"Circle, radius ${circle.radius}, [$circle]")

  private val rectangle = Rectangle(2, 3)
  println(s"Rectangle, ${rectangle.width} x ${rectangle.height}, [$rectangle]")

  private val square = Square(5)
  println(s"Square, ${square.side} x ${square.side}, [$square]")
}