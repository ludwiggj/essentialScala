package chapters.ch_4_2

import java.util.Date

sealed trait Visitor {
  def id: String

  def createdAt: Date

  def age: Long = new Date().getTime() - createdAt.getTime()
}

final case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

final case class User(id: String, email: String, createdAt: Date = new Date()) extends Visitor

object Main extends App {

  // This issues warning due to missing type Anonymous, but still runs
  def missingCase(v: Visitor) =
    v match {
      case User(_, _, _) => "Got a user"
    }

  println(missingCase(User("1", "bob@ajob.com")))
}