package chapters.ch_5_5_1

sealed trait A {
  def foo: String =
    "It's A!"
}

final case class B() extends A {
  override def foo: String =
    "It's B!"
}

final case class C() extends A {
  override def foo: String =
    "It's C!"
}

object workout extends App {
  val anA: A = B()
  println(anA.foo)
  val anOtherA: A = C()
  println(anOtherA.foo)
}