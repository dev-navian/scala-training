package io.turntabl
package blackJackGame

import scala.io.StdIn.{readInt, readLine}

object Game {

  def playGame(numberOfPlayers: Int): Unit = {
    println("===== Game Started =====")

    // initialize deck
    val deck = Deck()
    deck.initialize()

    // store of players in the game
    var gamePlayers: Map[String, Array[Card]] = Map()

    // print player cards
    def printPlayerCards(playerCards: Array[Card]): String = playerCards.mkString("[", ", ", "]")

    // compute card values
    def computeCardsValue(playerCards: Array[Card]): Int = {
      var value = 0
      for (card: Card <- playerCards) {
        value += card.value
      }
      value
    }

    for (i: Int <- 0 until  numberOfPlayers) yield {
      var playerCards = Array(deck.deal())
      playerCards = playerCards :+ deck.deal()

      val key: String = "Player" + (i + 1)
      gamePlayers = gamePlayers.+(key -> playerCards)
    }

    println(gamePlayers.size)
    println(gamePlayers.mkString("Map[", ", ", "]"))

//    for (player <- gamePlayers) {
//      val cardValues = computeCardsValue(player)
//
//      cardValues match {
//        case x: Int if(x >= 21) => println("Player")
//      }
//    }

    // display player cards
//    var playerOneCards = Array(deck.deal())
//    playerOneCards = playerOneCards :+ deck.deal()
//    println(s"playerOne cards: ${printPlayerCards(playerOneCards)}")
//    println(s"playerOne cards value: ${computeCardsValue(playerOneCards)}")
//
//    var playerTwoCards = Array(deck.deal())
//    playerTwoCards = playerTwoCards :+ deck.deal()
//    println(s"playerTwo cards: ${printPlayerCards(playerTwoCards)}")
//    println(s"playerTwo cards value: ${computeCardsValue(playerTwoCards)}")
//
//    var playerThreeCards = Array(deck.deal())
//    playerThreeCards = playerThreeCards :+ deck.deal()
//    println(s"playerThree cards: ${printPlayerCards(playerThreeCards)}")
//    println(s"playerThree cards value: ${computeCardsValue(playerThreeCards)}")
  }


  def main(args: Array[String]): Unit = {

    println("Welcome to Black Jack.")
    println("Would you want to start the game? [Y] / [N]")
    val userResponse: String = readLine()

    userResponse match {
      case "Y" =>
        println("Enter the number of players to play the game. eg. 5")

        val numberOfPlayers: Int = readInt()
        numberOfPlayers match {
          case x: Int if (x >= 1) && (x <= 6) => playGame(x)
          case _ => println("Sorry. The number of players should be between 1 and 6.")
        }

      case "N" => println("Sorry to see you leave. You should try this game.")
      case _ => println("Please enter an appropriate response.")
    }

  }
}
