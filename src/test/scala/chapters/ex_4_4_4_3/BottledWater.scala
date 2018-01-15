package chapters.ex_4_4_4_3

/*
    Bottled water has a size (an Int), a source (which is a well, spring, or tap), and a Boolean carbonated.
 */

object Source extends Enumeration {
    type Source = Value
    val Well, Spring, Tap = Value
  }

import Source._

case class BottledWater(size: Int, source: Source, carbonated: Boolean)

sealed trait Sourcez
final case object Well extends Sourcez
final case object Spring extends Sourcez
final case object Tap extends Sourcez

case class BottledWaterz(size: Int, source: Sourcez, carbonated: Boolean)

object bottlery extends App {
  BottledWater(2, Source.Well, true)
  BottledWaterz(2, Well, true)
}