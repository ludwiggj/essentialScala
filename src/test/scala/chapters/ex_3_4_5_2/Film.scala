package chapters.ex_3_4_5_2

case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
  def directorsAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(dir: Director) = director.name == dir.name
}

object Film {
  def highestRating(f1: Film, f2: Film) = {
    if (f1.imdbRating >= f2.imdbRating) f1.imdbRating else f2.imdbRating
  }

  def oldestDirectorAtTheTime(f1: Film, f2: Film) = {
    if (f1.directorsAge >= f2.directorsAge) f1.director else f2.director
  }
}