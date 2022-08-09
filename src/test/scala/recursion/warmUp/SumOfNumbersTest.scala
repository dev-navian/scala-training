package io.turntabl
package recursion.warmUp

import org.scalatest.funsuite.AnyFunSuite

class SumOfNumbersTest extends AnyFunSuite {

  // tests for ordinary recursion
  test("Sum of integers between 1 and 5 equals 9") {
    val result = SumOfNumbers.sumNumbers(1, 5);
    assert(result == 9);
  }

  test("Sum of integers between 4 and 8 equals 18") {
    val result = SumOfNumbers.sumNumbers(4, 8);
    assert(result != 20)
  }

  test("Sum of integers between 2 and 3 equals 0") {
    val result = SumOfNumbers.sumNumbers(2, 3);
    assert(result == 0)
  }


  // tests for tail recursion
  test("Tail recursion: Sum of integers between 1 and 5 equals 9") {
    val result = SumOfNumbers.sumNumbersTailRecursion(1, 5);
    assert(result == 9);
  }

  test("Tail recursion: Sum of integers between 4 and 8 equals 18") {
    val result = SumOfNumbers.sumNumbersTailRecursion(4, 8);
    assert(result != 20)
  }

  test("Tail recursion: Sum of integers between 2 and 3 equals 0") {
    val result = SumOfNumbers.sumNumbersTailRecursion(2, 3);
    assert(result == 0)
  }

}
