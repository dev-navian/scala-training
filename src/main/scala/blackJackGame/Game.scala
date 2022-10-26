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

    def printGamePlayerCards(gamePlayers: Map[String, Array[Card]]): Unit = {
      println("====== Players Cards ======")
      gamePlayers.foreach(e => println(e._2.mkString("Array(", ", ", ")")))
      println("==========================")
    }

    // populate player store with player cards
    for (i: Int <- 0 until  numberOfPlayers) yield {
      var playerCards = Array(deck.deal())
      playerCards = playerCards :+ deck.deal()

      val key: String = "Player" + (i + 1)
      gamePlayers = gamePlayers.+(key -> playerCards)
    }

    println(gamePlayers.size)
    println()
    printGamePlayerCards(gamePlayers)
    println()

    // handle player hitting...
//    def handlePlayerHitting(player: (String, Array[Card])): Unit = {
//
//    }

    def evaluateRound(gamers: Map[String, Array[Card]]): Unit = {

      if (gamers.size == 1) {
        val remainder: (String, Array[Card]) = gamers.head
        println(s"${remainder._1} WINS!!!")
        println(s"GAME OVER")
      } else {
        for (player: (String, Array[Card]) <- gamers) {
          val cardValues: Int = computeCardsValue(player._2)

          println(s"${player._1}'s cards: ${printPlayerCards(player._2)}")
          println(s"${player._1}'s value: $cardValues")

          cardValues match {
            case x: Int if (x < 17) => {
              println(s"${player._1} hits...")
              println(s"${player._1} gets another card...")
              println()
              val addedCards = player._2 :+ deck.deal()
              val newGamers = gamers + (player._1 -> addedCards)
              evaluateRound(newGamers)
              }
            case x: Int if (x >= 17) => {
              println(s"${player._1} sticks...")
            }
            case x: Int if (x == 21) => {
              println(s"${player._1} WINS!!!")
              println(s"GAME OVER")
            }
            case _ => {
              println(s"${player._1} goes bust...")

              val updatedGamePlayers = gamers.-(player._1)
              evaluateRound(updatedGamePlayers)

              println(s"${player._1} is ejected...")
            }
          }

          println()
        }
      }

    }

    evaluateRound(gamePlayers)

    // compute the total of all the cards a player has in a game
//    for (player: (String, Array[Card]) <- gamePlayers) {
//      val cardValues: Int = computeCardsValue(player._2)
//
//      println(s"${player._1}'s cards: ${printPlayerCards(player._2)}")
//      println(s"${player._1}'s value: $cardValues")
//
//      cardValues match {
//        case x: Int if (x < 17) =>
//          println(s"${player._1} hits...")
//          println(s"${player._1} gets another card...")
////          player._2 :+ deck.deal()
//        case x: Int if (x >= 17) =>
//          println(s"${player._1} sticks...")
//        case _ =>
//          println(s"${player._1} goes bust...")
//          gamePlayers = gamePlayers.-(player._1)
//          println(s"${player._1} is ejected...")
//      }
//
//      println()
//    }

    printGamePlayerCards(gamePlayers)
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
