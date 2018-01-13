package chapters.ex_5_4_4_1

/*
    A traffic light is red, green, or yellow. Translate this description into Scala code.
 */

sealed trait TrafficLight

final case class Red() extends TrafficLight
final case class Green() extends TrafficLight
final case class Yellow() extends TrafficLight

object Jam extends App {
  for (light <- List(Red, Yellow, Green)) {
    println(light)
  }
}
