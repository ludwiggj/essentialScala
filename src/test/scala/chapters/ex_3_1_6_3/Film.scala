package chapters.ex_3_1_6_3

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(dir: Director) = director.name == dir.name

  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating, director: Director = this.director) = {
    new Film(name, yearOfRelease, imdbRating, director)
  }

  override def toString: String = s"Film($name, $yearOfRelease, $imdbRating, $director)"
}