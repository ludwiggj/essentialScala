package chapters.ex_4_4_4_1

/*
    A traffic light is red, green, or yellow. Translate this description into Scala code.
 */

sealed trait TrafficLight

final case object Red extends TrafficLight
final case object Green extends TrafficLight
final case object Yellow extends TrafficLight

object Jam extends App {
  for (light <- List(Red, Yellow, Green)) {
    println(light)
  }
}
