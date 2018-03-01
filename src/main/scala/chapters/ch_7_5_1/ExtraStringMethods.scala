package chapters.ch_7_5_1

object EnrichIt {

  implicit class ExtraStringMethods(str: String) {
    val vowels = Seq('a', 'e', 'i', 'o', 'u')

    def numberOfVowels =
      str.toList.filter(vowels contains _).length
  }

  def main(args: Array[String]): Unit = {
    println("the quick brown fox".numberOfVowels)
  }
}