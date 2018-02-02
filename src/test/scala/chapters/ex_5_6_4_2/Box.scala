package chapters.ex_5_6_4_2

case class Box[+A](value: A) {
  def set[AA >: A](a: AA): Box[AA] = Box(a)
}