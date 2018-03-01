package chapters.ex_7_1_6_1

object OrderingExample {

  def main(args: Array[String]): Unit = {

    val absOrdering = Ordering.fromLessThan[Int](Math.abs(_) < Math.abs(_))

    assert(List(-4, -1, 0, 2, 3).sorted(absOrdering) == List(0, -1, 2, 3, -4))
    assert(List(-4, -3, -2, -1).sorted(absOrdering) == List(-1, -2, -3, -4))

    implicit val anotherAbsOrdering = Ordering.fromLessThan[Int](Math.abs(_) < Math.abs(_))

    assert(List(-4, -1, 0, 2, 3).sorted == List(0, -1, 2, 3, -4))
    assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))
  }
}
