package io.turntabl
package recursion.warmUp

import scala.annotation.tailrec

object IsAPrimeNumber {
  def main(args: Array[String]): Unit = {
    val res = isPrimeTailRecursion(3);
    println(res)
  }

  def isPrime(n: Int): Boolean = {
    false
  }

  def isPrimeTailRecursion(n: Int): Boolean = {

    @tailrec
    def isPrime(n: Int, index: Int = 2): Boolean = {
      if (n <= 1) false

      else if (n == 2) true

      else if (n != index && n % index == 0) false

      else if (n == index) true

      else isPrime(n, index + 1);
    }

    isPrime(n);
  }
}
