package chapters.ex_4_5_6_3

import java.util.Date

/*
Recall the Visitor trait we looked at earlier: a website Visitor is either Anonymous or a signed-in User. Now imagine
we wanted to add the ability to send emails to visitors. We can only email signed-in users, and sending an email
requires a lot of knowledge about SMTP settngs, MIME headers, and so on. Would an email method be better implemented
using polymorphism on the Visitor trait or using pattern matching in an EmailService object? Why?
 */
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

object EmailService {
  def emailUser(visitor: Visitor, settings: Any*): Unit = {
    def sendEmail(emailAddress: String, settings: Any*) {
      // send the email, ensuring correct SMTP settings, MIME headers etc.
    }

    visitor match {
      case User(_, email, _) => sendEmail(email, settings)
      case _ =>
    }
  }
}