package chapters.ch_4_1_1

import java.util.Date

trait Visitor {
  // Unique id assigned to each user
  def id: String

  // Date this user first visited the site
  def createdAt: Date

  // How long has this visitor been around?
  def age: Long = new Date().getTime - createdAt.getTime
}

case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

case class User(id: String, email: String, createdAt: Date = new Date()) extends Visitor

object Main extends App {
  def older(v1: Visitor, v2: Visitor): Boolean = v1.createdAt.before(v2.createdAt)

  println(older(Anonymous("1"), User("2", "test@example.com")))
}