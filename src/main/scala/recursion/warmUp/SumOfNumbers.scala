package io.turntabl
package recursion.warmUp

object SumOfNumbers {
  def main(args: Array[String]): Unit = {
    val res = sumNumbers(1, 5)
    println(res)
  }

  def sumNumbers(numOne: Int, numTwo: Int): Int = {
    if (numOne + 1 >= numTwo) 0

    else (numOne + 1) + sumNumbers(numOne + 1, numTwo)
  }
}
