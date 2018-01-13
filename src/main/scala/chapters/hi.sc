object person {
  val firstName = "G"
  val surname = "Ludwig"
}

object alien {
  def greet(peep: person.type ) = {
    "Hi" + peep.firstName
  }
}

alien.greet(person)