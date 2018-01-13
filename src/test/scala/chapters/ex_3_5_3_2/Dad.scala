package chapters.ex_3_5_3_2

import chapters.ex_3_4_5_2.{Film, Director}

object Dad {
  def rate(f: Film): Double = {
    f.director match {
      case Director("Clint", "Eastwood", _) => 10.0
      case Director("John", "McTiernan", _) => 7.0
      case _ => 3.0
    }
  }
}

object MovieNight extends App {
  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val someBody = new Director("Just", "Some Body", 1990)

  val invictus = new Film("Invictus", 2009, 7.4, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, someBody)

  println(Dad.rate(invictus))
  println(Dad.rate(predator))
  println(Dad.rate(thomasCrownAffair))
}