package chapters.ex_6_8_4_1

object SetUnion {

  def union[A](set1: Set[A], set2: Set[A]) = {
    set2.foldLeft(set1)((set, elem) => set + elem)
  }

  def main(args: Array[String]): Unit = {
    assert(union(Set(1, 2, 3), Set(4, 1, 6)) == Set(1, 2, 3, 4, 6))
  }
}
