package io.turntabl
package blackJackGame

case class Deck() {
  var count: Int = 52
  val cards: Array[Card] = new Array[Card](count)

  // create a deck from a combination of suits and the various face values
  def initialize(): Unit = {
    var counter = 0
    for (suit <- Suit.suits) {
      for (faceValue <- Values.faceValues) {
        cards(counter) = Card(suit, faceValue)
        counter += 1
      }
    }

    println("Deck initialized and ready...")
  }

  // shuffle the deck by switching the places of cards in the deck
  def shuffle(): Unit = {
    for (counter <- 1 to cards.length) {
      val randomInt = (math.random * counter).toInt
      val cardSelectedAtRandom = cards(randomInt)
      cards(randomInt) = cards(counter - 1)
      cards(counter - 1) = cardSelectedAtRandom
    }

    println("Deck shuffled successfully...")
  }

  // remove and serve the last element in the deck
  def deal(): Card = {
    if (count > 0) {
      count -= 1
      println("Card dealt...")
      cards(count)
    }
    else throw new NoSuchElementException("The current deck is empty")
  }

}

object Deck {

  def main(args: Array[String]): Unit = {
    val deck = new Deck
    deck.initialize()
    println(deck.cards.mkString("Array[", ", ", "]"))
    println(deck.cards.length)

    println()

    deck.shuffle()
    println(deck.deal())
    println(deck.deal())
    println(deck.deal())
  }

}
