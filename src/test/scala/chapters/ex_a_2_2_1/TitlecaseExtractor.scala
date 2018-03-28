package chapters.ex_a_2_2_1

object TitlecaseExtractor {

  object Titlecase {
    def unapply(s: String): Option[String] =
      Some(s.split(" ").toList.map(
        x => x.substring(0, 1).toUpperCase + x.substring(1)
      ).mkString(" "))
  }

  def main(args: Array[String]): Unit = {
    assert(
      "Sir Lord Doctor David Gurnell" ==
        ("sir lord doctor david gurnell" match {
          case Titlecase(str) => str
        })
    )
  }
}