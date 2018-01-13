package misc

object Trampolining extends App {
  def odd1(n: Int): Boolean = {
    if (n == 0) false
    else even1(n - 1)
  }

  def even1(n: Int): Boolean = {
    if (n == 0) true
    else odd1(n - 1)
  }


  println(s"15 is even? ${even1(15)}")
  println(s"22 is even? ${even1(22)}")
  println(s"9999 is even? ${even1(9999)}")

  // This causes stack overflow error i.e.
  // Exception in thread "main" java.lang.StackOverflowError
  // println(s"99999 is even? ${even1(99999)}")

  // All the calls in our example program are in tail position
  // But Scala can only optimise self calls in final methods and in local functions. It cannot optimise
  // non-final methods (because they might be overridden by a subclass), and it cannot optimise tail
  // calls that are made to different methods.

  // If you do find a call that you think should be optimised by the compiler, but isn't, then you should
  // check that the call:

  //    is a tail call,
  //    is in a final method or local function, and
  //    is to itself.

  // Trampolines

  // A trampoline is a loop that repeatedly runs functions. Each function, called a thunk, returns the next
  // function for the loop to run. The trampoline never runs more than one thunk at a time, so if you break
  // up your program into small enough thunks and bounce each one off the trampoline, then you can be sure
  // the stack won't grow too big.

  // Here is our program again, rewritten in trampolined style. Call objects contain the thunks and a Done object
  // contains the final result. Instead of making a tail call directly, each method now returns its call as a thunk
  // for the trampoline to run. This frees up the stack after each iteration. The effect is very similar to tail-call
  // optimisation.

  sealed trait Bounce[A]
  case class Done[A](result: A) extends Bounce[A]
  case class Call[A](thunk: () => Bounce[A]) extends Bounce[A]

  def trampoline[A](bounce: Bounce[A]): A = bounce match {
    case Call(thunk) => trampoline(thunk())
    case Done(x) => x
  }

  def even2(n: Int): Bounce[Boolean] = {
    if (n == 0) Done(true)
    else Call(() => odd2(n - 1))
  }
  def odd2(n: Int): Bounce[Boolean] = {
    if (n == 0) Done(false)
    else Call(() => even2(n - 1))
  }

  println(s"99999 is even? ${trampoline(even2(99999))}")
}
