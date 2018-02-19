package chapters.ex_6_10_1

object SentenceGenerator {
  def generate(): List[(String, String, String)] = {
    val subjects = List("Noel", "The cat", "The dog")

    for {
      subject <- subjects

      verbs = subject match {
        case "Noel" => List("wrote", "chased", "slept on")
        case "The cat" => List("meowed at", "chased", "slept on")
        case "The dog" => List("barked at", "chased", "slept on")
      }
      verb <- verbs

      objects = verb match {
        case "wrote" => List("the book", "the letter", "the code")
        case "chased" => List("the ball", "the dog", "the cat")
        case "slept on" => List("the bed", "the mat", "the train")
        case "meowed at" => List("Noel", "the door", "the food cupboard")
        case "barked at" => List("the postman", "the car", "the cat")
      }
      obj <- objects
    } yield (subject, verb, obj)
  }

  def main(args: Array[String]): Unit = {
    generate().foreach(println)
  }
}