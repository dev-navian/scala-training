package io.turntabl
package blackJackGame

import scala.io.StdIn.{readInt, readLine}

object Game {

  // main game play
  def playGame(numberOfPlayers: Int): Unit = {
    println("===== Game Started =====")

    // initialize and shuffle deck
    val deck = Deck()
    deck.initialize()
    deck.shuffle()

    // store of players in the game
    var gamePlayers: Map[String, Array[Card]] = Map()

    // print player cards
    def printSinglePlayerCards(playerCards: Array[Card]): String = playerCards.mkString("[", ", ", "]")

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
    for (i: Int <- 0 until  numberOfPlayers) {
      var playerCards = Array(deck.deal())
      playerCards = playerCards :+ deck.deal()

      val key: String = "Player" + (i + 1)
      gamePlayers = gamePlayers.+(key -> playerCards)
    }

    println(gamePlayers.size)
    println()
    printGamePlayerCards(gamePlayers)
    println()

    var gamersToNextRound: Map[String, Array[Card]] = Map()
    var stuckPlayers: Array[String] = Array()

    def evaluateRound(gamers: Map[String, Array[Card]]): Unit = {
      println(s"stuckPlayers Length: ${stuckPlayers.length}")
      println(s"gamers Size: ${gamers.size}")

      if (gamers.size == 1) {
        val remainder: (String, Array[Card]) = gamers.head
        println(s"${remainder._1} WINS!!!")
        println(s"GAME OVER!!!")
      } // check if all players stick
      else if (stuckPlayers.length == gamers.size) {
        println("All players stick...")
        println("GAME OVER!!!")
      }
      else {
        // compute the value of each player's cards
        for (player: (String, Array[Card]) <- gamers) {
          val cardValues: Int = computeCardsValue(player._2)

          println(s"${player._1}'s cards: ${printSinglePlayerCards(player._2)}")
          println(s"${player._1}'s value: $cardValues")

          cardValues match {
            case x: Int if (x < 17) => {
              println(s"${player._1} hits...")
              println(s"${player._1} gets another card...")
              println()

              val addedCards = player._2 :+ deck.deal()
              gamersToNextRound = gamers + (player._1 -> addedCards)
            }
            case x: Int if (x >= 17) => {
              stuckPlayers = stuckPlayers :+ player._1
              println(s"${player._1} sticks...")
            }
            case x: Int if (x == 21) => {
              println(s"${player._1} WINS!!!")
              println(s"GAME OVER!!!")
            }
            case _ => {
              println(s"${player._1} goes bust...")

              gamersToNextRound = gamers - (player._1)
//              evaluateRound(updatedGamePlayers)

              println(s"${player._1} is ejected...")
            }
          }

          println()
        }

        evaluateRound(gamersToNextRound)
      }

    }

    evaluateRound(gamePlayers)

  }


  def main(args: Array[String]): Unit = {

    println("Welcome to Black Jack.")
    println("Would you want to start the game? [Y] / [N]")
    val userResponse: String = readLine()

    userResponse match {
      case "Y" =>
        println("Enter the number of players to play the game. ie. between 1 and 6")

        val numberOfPlayers: Int = readInt()
        numberOfPlayers match {
          case x: Int if (x > 1) && (x <= 6) => playGame(x)
          case _ => println("Sorry. The number of players should be between 1 and 6.")
        }

      case "N" => println("Sorry to see you leave. You should try this game.")
      case _ => println("Please enter an appropriate response.")
    }
  }

}
