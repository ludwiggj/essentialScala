package chapters.ex_6_10_1

sealed trait Coin

final case object Heads extends Coin

final case object Tails extends Coin

object CoinToss {
  def main(args: Array[String]): Unit = {
    val fairCoin: Distribution[Coin] = Distribution.uniform (List (Heads, Tails) )
    val threeFlips =
      for {
        c1 <- fairCoin
        c2 <- fairCoin
        c3 <- fairCoin
      } yield (c1, c2, c3)

    println(threeFlips)
  }
}