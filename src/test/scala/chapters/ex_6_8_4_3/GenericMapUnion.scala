package chapters.ex_6_8_4_3

object GenericMapUnion {

  trait Addable[A] {
    def value(): A
    def add(a: Addable[A]): Addable[A]
  }

  def union[A, B](map1: Map[A, Addable[B]], map2: Map[A, Addable[B]]) = {
    map2.foldLeft(map1) {
      case (aMap, (k, v)) =>
        val newValue = aMap.get(k) match {
          case Some(addable) => addable.add(v)
          case _ => v
        }
        aMap + (k -> newValue)
    }
  }

  case class AddableInt(v: Int) extends Addable[Int] {
    override def value(): Int = v
    override def add(a: Addable[Int]): Addable[Int] = {
      AddableInt(v + a.value())
    }
  }

  case class AddableString(v: String) extends Addable[String] {
    override def value(): String = v
    override def add(a: Addable[String]): Addable[String] = {
      AddableString(v + a.value())
    }
  }

  def main(args: Array[String]): Unit = {
    assert(union[String, Int](
      Map("a" -> AddableInt(1), "b" -> AddableInt(2), "d" -> AddableInt(5)),
      Map("a" -> AddableInt(2), "b" -> AddableInt(4), "c" -> AddableInt(3))
    ) == Map("a" -> AddableInt(3), "b" -> AddableInt(6), "d" -> AddableInt(5), "c" -> AddableInt(3)))

    assert(union[String, String](
      Map("a" -> AddableString("1"), "b" -> AddableString("2"), "d" -> AddableString("5")),
      Map("a" -> AddableString("2"), "b" -> AddableString("4"), "c" -> AddableString("3"))
    ) == Map("a" -> AddableString("12"), "b" -> AddableString("24"), "d" -> AddableString("5"), "c" -> AddableString("3")))
  }
}