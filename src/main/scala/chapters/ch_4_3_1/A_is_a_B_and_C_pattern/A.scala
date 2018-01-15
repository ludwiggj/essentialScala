package chapters.ch_4_3_1.A_is_a_B_and_C_pattern

/*
If A is a B and a C
 */

trait B
trait C

trait A extends B with C

/*
NOTE:

If we want to represent that some data conforms to a number of different interfaces we will often be better off using a
type class. There are, however, several legitimate uses of this pattern:

• for modularity, using what’s known as the cake pattern; and
• sharing implementation across several classes where it doesn’t make sense to make default implementations in the main
  trait.
 */