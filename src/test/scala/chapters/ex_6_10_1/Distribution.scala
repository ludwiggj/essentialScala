package chapters.ex_6_10_1

final case class Distribution[A](events: List[(A, Double)]) {
  def map[B](f: A => B): Distribution[B] = {
    Distribution(events.map { case (elem, pct) => f(elem) -> pct })
  }

  def flatMap[B](f: A => Distribution[B]): Distribution[B] = {
    val newEvents = for {
      (valueA, weightA) <- events
      (valueB, weightB) <- f(valueA).events
    } yield (valueB, weightA * weightB)
    Distribution(newEvents).compact.normalize
  }

  def filter(p: ((A, Double)) => Boolean): Distribution[A] = {
    Distribution.discrete(events.filter(p))
  }

  def normalize: Distribution[A] = {
    val totalWeight = (events map { case (_, p) => p }).sum
    Distribution(events map { case (a, p) => a -> (p / totalWeight) })
  }

  def compact: Distribution[A] = {
    val distinct = (events map { case (a, p) => a }).distinct

    def prob(a: A): Double =
      (events filter { case (x, p) => x == a } map { case (a, p) => p }).sum

    Distribution(distinct map { a => a -> prob(a) })
  }
}

object Distribution {
  def uniform[A](l: List[A]) = {
    val pct = 1.0 / l.size
    Distribution(l.map(elem => elem -> pct))
  }

  def discrete[A](events: List[(A, Double)]): Distribution[A] =
    Distribution(events).compact.normalize
}

object TestRun {
  def intToString(i: Int): String = {
    i.toString + i.toString
  }

  def main(args: Array[String]): Unit = {
    println(Distribution.uniform(List("Hey", "Ho")))
    println(Distribution.uniform(List(true, false)))
    println(Distribution.uniform(List(1, 2, 3, 4, 5)))
    println(Distribution.uniform(List(1, 2, 3, 4, 5)).map(intToString))
    println(Distribution(List("a" -> 0.2, "b" -> 0.3)).normalize)

    assert(Distribution(List("a" -> 0.2, "b" -> 0.3)).normalize == Distribution(List("a" -> 0.4, "b" -> 0.6)))
    println(Distribution(List("a" -> 0.2, "b" -> 0.3, "a" -> 0.5)).compact)

    println(Distribution.uniform("abcde".toList))

    val initialD = Distribution(List("abcd" -> 0.5, "ef" -> 0.5))

    val flatMappedD = initialD.flatMap(x => Distribution.uniform(x.toList))

    println(flatMappedD)

    assert(flatMappedD == Distribution(
      List('a' -> 0.125, 'b' -> 0.125, 'c' -> 0.125, 'd' -> 0.125, 'e' -> 0.25, 'f' -> 0.25))
    )

    println(flatMappedD.filter { case (ch, _) => ch <= 'd' })
  }
}