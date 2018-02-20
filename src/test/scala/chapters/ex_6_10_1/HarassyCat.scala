package chapters.ex_6_10_1

sealed trait Food

final case object Delicious extends Food

final case object Raw extends Food

sealed trait Cat

final case object HarassyCat extends Cat

final case object SleepyCat extends Cat

object CatExperiment {
  def main(args: Array[String]): Unit = {

    // I put my food into the oven and after some time it is ready to eat and produces a delicious smell
    // with probability 0.3 and otherwise it is still raw and produces no smell with probability 0.7.

    val dinner = Distribution(List(Delicious -> 0.3, Raw -> 0.7))

    // If there are delicious smells the cat comes to harass me with probability 0.8, and otherwise it
    // stays asleep. If there is no smell the cat harasses me for the hell of it with probability 0.4
    // and otherwise stays asleep.

    // Q: if the cat comes to harass me what is the probability my food is producing delicious smells?

    def cat: Food => Distribution[Cat] = f => f match {
      case Delicious => Distribution(List(HarassyCat -> 0.8, SleepyCat -> 0.2))
      case Raw => Distribution(List(HarassyCat -> 0.4, SleepyCat -> 0.6))
    }

    val result: Distribution[(Food, Cat)] = (for {
      f <- dinner
      c <- cat(f)
    } yield (f, c))

    println(result)

    def catIsHarassy(fcd: ((Food, Cat), Double)): Boolean = {
      fcd._1._2 == HarassyCat
    }

    val harassyCat = result.filter(catIsHarassy)
    println(harassyCat)

    // Textbook solution...

    // Probability the cat is harassing me
    val pHarassing: Double =
      result.events filter {
        case ((_, HarassyCat), _) => true
        case ((_, SleepyCat), _) => false
      } map { case (a, p) => p } sum

    println(s"Probability the cat is harassing me = $pHarassing")

    val pCookedGivenHarassing: Option[Double] =
      result.events collectFirst[Double] {
        case ((Delicious, HarassyCat), p) => p
      } map (_ / pHarassing)

    println(s"Probability that if the cat is harassing me then the food is cooked = $pCookedGivenHarassing")
  }
}