package io.turntabl
package blackJackGame

import scala.io.StdIn.{readInt, readLine}

object Game {

  def playGame(numberOfPlayers: Int): Unit = {
    println("===== Game Started =====")

    //    println("Enter the number of players you want... (A valid input is a digit between 1 and 6)")
//    val numberOfPlayers = readInt()
    val deck = Deck()
    deck.initialize()

    var gamePlayers: Array[Array[Card]] = Array()

    // print player cards
    def printPlayerCards(playerCards: Array[Card]): String = playerCards.mkString("[", ", ", "]")

    // compute card values
    def computeCardsValue(playerCards: Array[Card]): Int = {
      var value = 0
      for (card <- playerCards) {
        value += card.value
      }
      value
    }

    for (i <- 0 until  numberOfPlayers) {
      var playerCards = Array(deck.deal())
      playerCards = playerCards :+ deck.deal()

      gamePlayers = gamePlayers :+ (playerCards)
      println("populating array... \n")
    }

    println(gamePlayers.length)
    println(gamePlayers.mkString("Array(", ", ", ")"))

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
