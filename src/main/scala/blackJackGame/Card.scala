package io.turntabl
package blackJackGame

case class Card(suit: String, faceValue: String) {

  def value: Int = faceValue match {
    case "Jack" => 10
    case "King" => 10
    case "Queen" => 10
    case "Ace" => 10
    case _ => faceValue.toInt
  }

  override def toString: String =  s"$faceValue of $suit"
}

//object Card {
//  def main(args: Array[String]): Unit = {
//    val cardOne = Card(Suit.suits(1), Values.faceValues(9))
//    println(cardOne.toString)
//    println(cardOne.value)
//  }
//}