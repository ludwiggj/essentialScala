package chapters.ex_6_8_4_3

object GenericMapUnionBetter {

  def union[A, B](map1: Map[A, B], map2: Map[A, B], add: (B, B) => B) = {
    map2.foldLeft(map1) {
      case (aMap, (k, v)) =>
        val newValue = aMap.get(k).map(add(_, v)).getOrElse(v)
        aMap + (k -> newValue)
    }
  }

  def main(args: Array[String]): Unit = {
    assert(union[String, Int](
      Map("a" -> 1, "b" -> 2, "d" -> 5), Map("a" -> 2, "b" -> 4, "c" -> 3), _ + _
    ) == Map("a" -> 3, "b" -> 6, "d" -> 5, "c" -> 3))

    assert(union[String, String](
      Map("a" -> "1", "b" -> "2", "d" -> "5"), Map("a" -> "2", "b" -> "4", "c" -> "3"), _ + _
    ) == Map("a" -> "12", "b" -> "24", "d" -> "5", "c" -> "3"))
  }
}