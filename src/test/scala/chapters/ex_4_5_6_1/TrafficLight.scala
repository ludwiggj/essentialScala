package chapters.ex_4_5_6_1

/*
Using polymorphism and then using pattern matching implement a method called next which returns the next
TrafficLight in the standard Red -> Green -> Yellow -> Red cycle. Do you think it is better to implement this method
inside or outside the class? If inside, would you use pattern matching or polymorphism? Why?
 */

sealed trait TrafficLight {
  // Polymorphic approach
  def next: TrafficLight

  // Pattern matching
  // Better inside
  def change: TrafficLight = {

    // This is better as likely to add new methods not new data
    this match {
      case Red => Green
      case Green => Yellow
      case Yellow => Red
    }
  }
}

final case object Red extends TrafficLight {
  def next = Green
}

final case object Green extends TrafficLight {
  def next = Yellow
}

final case object Yellow extends TrafficLight {
  def next = Red
}

