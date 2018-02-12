package chapters.ex_6_2_7_2

object Exercise extends App {

  def minimum(seq: Seq[Int]): Int = {
//    seq.fold(Int.MaxValue)((min, x) => if (x < min) x else min)
    seq.fold(Int.MaxValue)(math.min)
  }

  def unique(seq: Seq[Int]): Seq[Int] = {
    seq.foldLeft(Seq.empty[Int])((aSeq, x) => if (aSeq.contains(x)) aSeq else (x +: aSeq))
  }

  def reverse[A](seq: Seq[A]): Seq[A] = {
    seq.foldLeft(Seq.empty[A])((aSeq, x) => x +: aSeq)
  }

  def map[A, B](seq: Seq[A], f: A => B): Seq[B]= {
    seq.foldRight(Seq.empty[B])((a, seqB) => f(a) +: seqB)
  }

  def foldLeft[A, B](seq: Seq[A])(z: B)(op: (B, A) => B): B = {
    var result = z
    seq foreach(x => result = op(result, x))
    result
  }

  assert(minimum(Seq(3, 5, 1, 9)) == 1)
  assert(unique(Seq(1, 1, 2, 4, 3, 4)) == Seq(3, 4, 2, 1))
  assert(reverse(Seq(1, 2, 3, 4, 5)) == Seq(5, 4, 3, 2, 1))
  assert(reverse(Seq("The", "cat", "sat", "on", "the", "mat")) == Seq("mat", "the", "on", "sat", "cat", "The"))
  assert(map[Int, Int](Seq(1, 2, 3, 4, 5), _ * 2) == Seq(2, 4, 6, 8, 10))

  assert(foldLeft(Seq(1,2,3,4))(0)((b, a) => b + a) == 10)
  assert(foldLeft(Seq(1,2,3,4))(1)((b, a) => b * a) == 24)
}