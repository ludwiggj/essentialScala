package chapters.ex_3_3_2_2

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(dir: Director) = director.name == dir.name

  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating, director: Director = this.director) = {
    new Film(name, yearOfRelease, imdbRating, director)
  }

  override def toString: String = s"Film($name, $yearOfRelease, $imdbRating, $director)"
}

object Film {
  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) = {
    new Film(name, yearOfRelease, imdbRating, director)
  }

  def highestRating(f1: Film, f2: Film) = {
    if (f1.imdbRating >= f2.imdbRating) f1.imdbRating else f2.imdbRating
  }

  def oldestDirectorAtTheTime(f1: Film, f2: Film) = {
    if (f1.directorsAge >= f2.directorsAge) f1.director else f2.director
  }
}