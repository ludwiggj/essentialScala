package chapters.ex_a_2_2_1

object PositiveExtractor {

  object Positive {
    def unapply(i: Int): Option[Int] =
      if (i > 0) Some(i) else None
  }

  def main(args: Array[String]): Unit = {
    assert(
      "No" ==
        (0 match {
          case Positive(_) => "Yes"
          case _ => "No"
        })
    )
    assert(
      "Yes" ==
        (42 match {
          case Positive(_) => "Yes"
          case _ => "No"
        })
    )
  }
}
