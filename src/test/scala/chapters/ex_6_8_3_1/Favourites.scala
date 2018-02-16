package chapters.ex_6_8_3_1

object Favourites extends App {
  val people = Set(
    "Alice",
    "Bob",
    "Charlie",
    "Derek",
    "Edith",
    "Fred")

  val ages = Map(
    "Alice" -> 20,
    "Bob" -> 30,
    "Charlie" -> 50,
    "Derek" -> 40,
    "Edith" -> 10,
    "Fred" -> 60)

  val favoriteColours = Map(
    "Bob" -> "green",
    "Derek" -> "magenta",
    "Fred" -> "yellow")

  val favoriteLolcats = Map(
    "Alice" -> "Long Cat",
    "Charlie" -> "Ceiling Cat",
    "Edith" -> "Cloud Cat")

  def favoriteColour(person: String) = {
    favoriteColours.get(person)
  }

  def favoriteColourWithDefault(person: String) = {
    favoriteColours.getOrElse(person, "beige")
  }

  def printColours() = {
    for (p <- people) println(s"$p's favourite colour is ${favoriteColourWithDefault(p)}")
  }

  def lookup[A](person: String, map: Map[String, A]): Option[A] = {
    map get person
  }

  def colourOfOldestPerson() = {
    val ageAndColour = for {
      (name, age) <- ages
    } yield (age, favoriteColourWithDefault(name))

    ageAndColour(ageAndColour.keys.max)
  }

  def oldestPerson(): Option[String] = {
    val oldest = ages.foldLeft(Option.empty[(String, Int)]) {
      case (oldestSoFar, candidate) => oldestSoFar match {
        case None => Some(candidate)
        case Some((_, age)) =>
          if (candidate._2 > age) Some(candidate) else oldestSoFar
      }
    }

    oldest.map(_._1)
  }

  val oldest: Option[String] =
    people.foldLeft(Option.empty[String]) { (older, person) =>
      if(ages.getOrElse(person, 0) > older.flatMap(ages.get).getOrElse(0)) {
        Some(person)
      } else {
        older
      }
    }

  assert(favoriteColour("Bob") == Some("green"))
  assert(favoriteColour("Graeme") == None)

  assert(favoriteColourWithDefault("Bob") == "green")
  assert(favoriteColourWithDefault("Graeme") == "beige")

  printColours()

  assert(lookup("Bob", ages) == Some(30))
  assert(lookup("Bob", favoriteColours) == Some("green"))
  assert(lookup("Bob", favoriteLolcats) == None)
  assert(lookup("Alice", favoriteLolcats) == Some("Long Cat"))

  assert(colourOfOldestPerson() == "yellow")
  assert(oldestPerson() == Some("Fred"))
  assert(oldest == Some("Fred"))
}