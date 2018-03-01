package chapters.ex_7_6_3

object EasyEquality {

  trait Equal[A] {
    def equal(v1: A, v2: A): Boolean
  }

  object EqualityImplicits {

    implicit class Equality[A](v1: A) {
      def ===(v2: A)(implicit eq: Equal[A]): Boolean = {
        eq.equal(v1, v2)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    implicit object StringEquality extends Equal[String] {
      override def equal(v1: String, v2: String): Boolean = {
        v1.equalsIgnoreCase(v2)
      }
    }

    import EqualityImplicits._

    println("abcd" === "ABCD")
    println("abcd" === "ABCDe")

  }
}