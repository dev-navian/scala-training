package io.turntabl
package recursion.warmUp

import scala.annotation.tailrec

object SumOfNumbers extends App {

  // ordinary recursion
  def sumNumbers(numOne: Int, numTwo: Int): Int = {
    if (numOne + 1 >= numTwo) 0

    else (numOne + 1) + sumNumbers(numOne + 1, numTwo)
  }

  // with tail recursion
  def sumNumbersTailRecursion(numOne: Int, numTwo: Int): Int = {

    @tailrec
    def sumOfNumbers(numOne: Int, numTwo: Int, acc: Int): Int  = {
      if (numOne + 1 >= numTwo) acc

      else sumOfNumbers((numOne + 1), numTwo, (numOne + 1) + acc);
    }

    sumOfNumbers(numOne, numTwo, 0);
  }
}
