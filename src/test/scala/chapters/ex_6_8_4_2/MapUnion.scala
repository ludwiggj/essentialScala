package chapters.ex_6_8_4_2

object MapUnion {

  def union[A](map1: Map[A, Int], map2: Map[A, Int]) = {
    map2.foldLeft(map1) {
      case (aMap, (k, v)) => aMap + (k -> (v + aMap.getOrElse(k, 0)))
    }
  }

  def union2[A](map1: Map[A, Int], map2: Map[A, Int]): Map[A, Int] = {
    map1.foldLeft(map2){ (map, elt) =>
      val (k, v) = elt
      val newV = map.getOrElse(k, v)
      map + (k -> newV)
    }
  }

  def main(args: Array[String]): Unit = {
    assert(union(Map("a" -> 1, "b" -> 2, "d" -> 5), Map("a" -> 2, "b" -> 4, "c" -> 3))
      == Map("a" -> 3, "b" -> 6, "d" -> 5, "c" -> 3))

    assert(union2(Map("a" -> 1, "b" -> 2, "d" -> 5), Map("a" -> 2, "b" -> 4, "c" -> 3))
      == Map("a" -> 3, "b" -> 6, "d" -> 5, "c" -> 3))
  }
}
