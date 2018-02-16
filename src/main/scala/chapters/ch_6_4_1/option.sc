def readInt(str: String): Option[Int] =
  if(str matches "\\d+") Some(str.toInt) else None

val a = Seq(readInt("1"), readInt("b"), readInt("3"))

a.flatMap(x => x)