package io.turntabl
package recursion.warmUp

import scala.annotation.tailrec

object FibonacciNumber extends App {

  def calculateFibNumber(n: Int): Int = {
    if (n == 0) 0
    else if (n == 1) 1
    else calculateFibNumber(n - 1) + calculateFibNumber(n - 2)
  }

  def calculateFibNumberTailRecursively(n: Int): Int = {

    @tailrec
    def calcFibNumber(n: Int, start: Int, next: Int): Int = {
      if (n == 0) start
      else if (n == 1) next
      else calcFibNumber(n - 1, next, next + start);
    }

    calcFibNumber(n, 0, 1);
  }
}
