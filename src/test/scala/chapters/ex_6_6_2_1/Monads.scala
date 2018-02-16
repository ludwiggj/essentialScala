package chapters.ex_6_6_2_1

object MonadExamples extends App {
  import scala.util.Try
  val opt1 = Some(1)
  val opt2 = Some(2)
  val opt3 = Some(3)

  val combinedOpt = for {
    o1 <- opt1
    o2 <- opt2
    o3 <- opt3
  } yield (o1 + o2 + o3)

  val seq1 = Seq(1)
  val seq2 = Seq(2)
  val seq3 = Seq(3)

  val combinedSeq = for {
    s1 <- seq1
    s2 <- seq2
    s3 <- seq3
  } yield s1 + s2 + s3

  val try1 = Try(1)
  val try2 = Try(2)
  val try3 = Try(3)

  val combinedTry = for {
    t1 <- try1
    t2 <- try2
    t3 <- try3
  } yield t1 + t2 + t3

  println(combinedOpt) // Some(6)
  println(combinedSeq) // List(6)
  println(combinedTry) // Success(6)
}
