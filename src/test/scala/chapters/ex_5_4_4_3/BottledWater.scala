package chapters.ex_5_4_4_3

/*
    Bottled water has a size (an Int), a source (which is a well, spring, or tap), and a Boolean carbonated.
 */


object Source extends Enumeration {
    type Source = Value
    val Well, Spring, Tap = Value
  }

import Source._

case class BottledWater(size: Int, source: Source, carbonated: Boolean)

object bottlery extends App {
  BottledWater(2, Source.Well, true)
}