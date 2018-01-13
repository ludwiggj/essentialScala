package chapters.ex_5_2_2_2

/*
Write a sealed trait Color to make our shapes more interesting.

• give Color three properties for its RGB values;
• create three predefined colours: Red, Yellow, and Pink;
• provide a means for people to produce their own custom Colors with their own RGB values;
• provide a means for people to tell whether any Color is “light” or “dark”.

A lot of this exercise is left deliberately open to interpretation. The important thing is to practice
working with traits, classes, and objects.

Decisions such as how to model colours and what is considered a light or dark colour can either be left
up to you or discussed with other class members.
 */

object Colour {
  val Dark = "Dark"
  val Light = "Light"
  val CustomColourName = "Custom"
}

import Colour._

sealed trait Colour {
  def red: Short
  def green: Short
  def blue: Short
  def name = CustomColourName

  def lightOrDark = {
     if ((Math.sqrt(red * red * .241 + green * green * .691 + blue * blue * .068)) < 130)
       Dark else Light
  }
}

final case class Red() extends Colour {
  val red: Short = 255
  val green: Short = 0
  val blue: Short = 0
  override val name = "Red"
}

final case class Yellow() extends Colour {
  val red: Short = 255
  val green: Short = 255
  val blue: Short = 0
  override val name = "Yellow"
}

final case class Pink() extends Colour {
  val red: Short = 255
  val green: Short = 192
  val blue: Short = 203
  override val name = "Pink"
}

final case class CustomColour(red: Short, green: Short, blue: Short) extends Colour

object Colourz extends App {
  def displayLuminescence(c: Colour): Unit = {
    println(s"Colour ${c.name} (${c.red}, ${c.green}, ${c.blue}) is ${c.lightOrDark}")
  }

  displayLuminescence(Red())
  displayLuminescence(Yellow())
  displayLuminescence(Pink())
  displayLuminescence(CustomColour(0,0,0))
  displayLuminescence(CustomColour(255,255,255))
}