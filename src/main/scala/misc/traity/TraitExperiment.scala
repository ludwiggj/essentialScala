package misc.traity

trait Parent {
  val speak = (x: String) => println(x)
}

trait Child extends Parent {
  override val speak: String => Unit = (x: String) => println(s"Oy Dad: $x")
}

object TraitExperiment {

  def main(args: Array[String]): Unit = {
    new Parent {}.speak("Hi")
    new Child {}.speak("Hi")
  }
}
