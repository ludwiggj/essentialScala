package chapters.ex_4_7_0_2

object JSON extends App {

  /*
  Design an algebraic data type to represent JSON. Don’t go directly to code. Start by sketching out the design
  in terms of logical ands and ors—the building blocks of algebraic data types. You might find it useful to use
  a notation similar to [BNF]

  Note you’ll need a sequence type to model JSON, and we haven’t looked at Scala’s collection library yet. However
  we have seen how to implement a list as an algebraic data type.

  Here are some examples of JSON you’ll need to be able to represent.

  ["a string", 1.0, true]
  {
    "a": [1,2,3],
    "b": ["a","b","c"]
    "c": { "doh":true, "ray":false, "me":1 }
  }

  */

  // (1) First attempt

  // JsonString ::= value:String
  // JsonNumber ::= value:Double
  // JsonBoolean ::= value:Boolean
  // JsonArray ::= values:List[JsonValue]
  // JsonProperty ::= key:String value: JsonValue
  // JsonObject ::= properties:List[JsonProperty]

  // JsonValue ::= JsonString | JsonNumber | JsonBoolean | JsonArray | JsonObject


  // (2) Rename to use the same nomenclature of model solution

  // Json ::= JsNumber | JsString | JsBoolean | JsArray | JsObject

  // JsNumber ::= value:Double
  // JsString ::= value:String
  // JsBoolean ::= value:Boolean
  // JsArray ::= values:List[JsValue]
  // JsProperty ::= key:String value: JsValue
  // JsObject ::= properties:List[JsProperty]

  // (3) Overlooked the key hint about modelling lists...

  // sealed trait IntList
  // final case object End extends IntList
  // final case class Pair(head: Int, tail: IntList) extends IntList

  // So I can now remodel this...

  // Json ::= JsNumber value:Double
  //        | JsString value:String
  //        | JsBoolean value:Boolean
  //        | JsNull
  //        | JsSeq
  //        | JsObject

  // JsSeq ::= SeqCell head: Json tail: JsSeq
  //         | SeqEnd

  // JsObject ::= ObjectCell key:String value: Json tail: JsObject
  //            | ObjectEnd

  sealed trait Json {
    private def quoteString(s: String) = {
      "\"" + s + "\""
    }

    private def seqToJson(s: SeqCell): String = {
      s match {
        case SeqCell(head, tail:SeqCell) => s"${head.asStr}, ${seqToJson(tail)}"
        case SeqCell(head, SeqEnd) => head.asStr
      }
    }

    private def objToJson(o: ObjectCell): String = {
      o match {
        case ObjectCell(key, value, tail: ObjectCell) => s"${quoteString(key)}: ${value.asStr}, ${objToJson(tail)}"
        case ObjectCell(key, value, ObjectEnd) => s"${quoteString(key)}: ${value.asStr}"
      }
    }

    private def asStr = {
      val asStr: String =
        this match {
          case JsNumber(v) => v.toString
          case JsString(v) => quoteString(v)
          case JsBoolean(v) => v.toString
          case JsNull => "Null"
          case s@SeqCell(_, _) => "[" ++ seqToJson(s) ++ "]"
          case SeqEnd => "[]"
          case o@ObjectCell(_, _, _) => "{" ++ objToJson(o) ++ "}"
          case ObjectEnd => "{}"
        }
      asStr
    }

    def print = {
      println(asStr)
    }
  }

  final case class JsNumber(value: Double) extends Json

  final case class JsString(value: String) extends Json

  final case class JsBoolean(value: Boolean) extends Json

  final case object JsNull extends Json

  sealed trait JsSeq extends Json

  final case class SeqCell(head: Json, tail: JsSeq) extends JsSeq

  final case object SeqEnd extends JsSeq

  sealed trait JsObject extends Json

  final case class ObjectCell(key: String, value: Json, tail: JsObject) extends JsObject

  final case object ObjectEnd extends JsObject

  // ["a string", 1.0, true]
  val json1 = SeqCell(JsString("a string"), SeqCell(JsNumber(1.0), SeqCell(JsBoolean(true), SeqEnd)))

  // {
  // "a": [1,2,3],
  // "b": ["a","b","c"]
  // "c": { "doh":true, "ray":false, "me":1 }
  // }

  val json2 =
    ObjectCell(
      "a", SeqCell(JsNumber(1.0), SeqCell(JsNumber(2.0), SeqCell(JsNumber(3.0), SeqEnd))),
      ObjectCell(
        "b", SeqCell(JsString("a"), SeqCell(JsString("b"), SeqCell(JsString("c"), SeqEnd))),
        ObjectCell(
          "c", ObjectCell("doh", JsBoolean(true),
            ObjectCell("ray", JsBoolean(false),
              ObjectCell("me", JsNumber(1), ObjectEnd))),
          ObjectEnd
        )
      )
    )

  JsNumber(2.5).print
  JsString("A string").print
  JsBoolean(true).print
  JsNull.print
  SeqEnd.print
  ObjectEnd.print
  json1.print
  json2.print
}