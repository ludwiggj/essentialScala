package chapters.ex_6_5_1_1

object Adder extends App {
  def addOptions(a: Option[Int], b: Option[Int]) = {
    for {
      a1 <- a
      b1 <- b
    } yield a1 + b1
  }

  def addOptionsAgain(a: Option[Int], b: Option[Int]) = {
    a flatMap(a1 => b map (b1 => a1 + b1))
  }

  assert(addOptions(Some(1), Some(2)) == Some(3))
  assert(addOptions(Some(1), None) == None)
  assert(addOptions(None, Some(1)) == None)

  assert(addOptionsAgain(Some(1), Some(2)) == Some(3))
  assert(addOptionsAgain(Some(1), None) == None)
  assert(addOptionsAgain(None, Some(1)) == None)

  def addOptions(a: Option[Int], b: Option[Int], c: Option[Int]) = {
    for {
      a1 <- a
      b1 <- b
      c1 <- c
    } yield a1 + b1 + c1
  }

  def addOptionsAgain(a: Option[Int], b: Option[Int], c: Option[Int]) = {
    a flatMap(a1 => b flatMap (b1 => c map (c1 => a1 + b1 + c1)))
  }

  assert(addOptions(Some(1), Some(2), Some(3)) == Some(6))
  assert(addOptions(Some(1), Some(2), None) == None)
  assert(addOptions(Some(1), None, Some(3)) == None)
  assert(addOptions(None, Some(2), Some(3)) == None)

  assert(addOptionsAgain(Some(1), Some(2), Some(3)) == Some(6))
  assert(addOptionsAgain(Some(1), Some(2), None) == None)
  assert(addOptionsAgain(Some(1), None, Some(3)) == None)
  assert(addOptionsAgain(None, Some(2), Some(3)) == None)
}
