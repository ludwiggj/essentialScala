val animals = Seq("cat", "dog", "penguin")

val moreAnimals = "mouse" +: animals :+ "tyrannosaurus"

val noah = 2 +: moreAnimals

import scala.collection.mutable

val mutableAnimals = mutable.Seq("cat", "dog", "penguin")

mutableAnimals(1) = 2