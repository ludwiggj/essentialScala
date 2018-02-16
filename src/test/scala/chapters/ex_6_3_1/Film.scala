package chapters.ex_6_3_1

case class Film(name: String,
                yearOfRelease: Int,
                imdbRating: Double)

case class Director(firstName: String,
                    lastName: String,
                    yearOfBirth: Int,
                    films: Seq[Film])

object Exercise extends App {
  val memento = new Film("Memento", 2000, 8.5)
  val darkKnight = new Film("Dark Knight", 2008, 9.0)
  val inception = new Film("Inception", 2010, 8.8)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven = new Film("Unforgiven", 1992, 8.3)
  val granTorino = new Film("Gran Torino", 2008, 8.2)
  val invictus = new Film("Invictus", 2009, 7.4)
  val predator = new Film("Predator", 1987, 7.9)
  val dieHard = new Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)

  val eastwood = new Director("Clint", "Eastwood", 1930,
    Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))

  val mcTiernan = new Director("John", "McTiernan", 1951,
    Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))

  val nolan = new Director("Christopher", "Nolan", 1970,
    Seq(memento, darkKnight, inception))

  val someGuy = new Director("Just", "Some Guy", 1990,
    Seq())

  val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

  val nolanFilms = nolan.films.map(_.name)
  println(nolanFilms)

  val nolanFilmz = for (f <- nolan.films) yield f.name
  println(nolanFilmz)

  val allFilms = directors.flatMap(_.films.map(_.name))
  println(allFilms)

  val allFilmz = for {
    d <- directors
    f <- d.films
  } yield f.name

  println(allFilmz)

  val earliestMcTiernanFilm = mcTiernan.films.sortWith(_.yearOfRelease < _.yearOfRelease).headOption.map(_.yearOfRelease)
  println(earliestMcTiernanFilm)

  val earliestMcTiernanFilm2 = mcTiernan.films.foldLeft(Int.MaxValue) { (current, film) =>
    math.min(current, film.yearOfRelease)
  }
  println(earliestMcTiernanFilm2)

  val highScoreTable = directors.flatMap(_.films).sortWith(_.imdbRating > _.imdbRating)
  println(highScoreTable)

  val highScorezTable = (for {
    d <- directors
    f <- d.films
  } yield f).sortWith(_.imdbRating > _.imdbRating)

  println(highScorezTable)

  val allTheFilms = directors.flatMap(_.films)
  val averageScore = (allTheFilms.foldLeft(0.0)((t, f) => t + f.imdbRating)) / allTheFilms.size
  println(averageScore)

  directors.foreach(d => d.films.foreach(f =>
    println(s"Tonight only! ${f.name} by ${d.firstName} ${d.lastName}")
  ))

  for {
    d <- directors
    f <- d.films
  } {
    println(s"TONIGHT only! ${f.name} by ${d.firstName} ${d.lastName}")
  }

  val earliestFilm = directors.flatMap(_.films).sortWith(_.yearOfRelease < _.yearOfRelease).headOption
  println(earliestFilm)
}