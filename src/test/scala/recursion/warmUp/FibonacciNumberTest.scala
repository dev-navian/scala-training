package io.turntabl
package recursion.warmUp

import org.scalatest.funsuite.AnyFunSuite

class FibonacciNumberTest extends AnyFunSuite {

  // ordinary recursion
  test("fibonacci number of a provided value 5 is 5") {
    val res = FibonacciNumber.calculateFibNumber(5);
    assert(res == 5);
  }

  test("fibonacci number of a provided value 4 is 3") {
    val res = FibonacciNumber.calculateFibNumber(4);
    assert(res == 3);
  }

  test("fibonacci number of a provided value 0 is 0") {
    val res = FibonacciNumber.calculateFibNumber(0);
    assert(res == 0);
  }

  // tail recursion
  test("Tail Recursion: fibonacci number of a provided value 4 is 3") {
    val res = FibonacciNumber.calculateFibNumberTailRecursively(4);
    assert(res == 3);
  }

  test("Tail Recursion: fibonacci number of a provided value 5 is 5") {
    val res = FibonacciNumber.calculateFibNumberTailRecursively(5);
    assert(res == 5);
  }

  test("Tail recursion: fibonacci number of a provided value 0 is 0") {
    val res = FibonacciNumber.calculateFibNumberTailRecursively(0);
    assert(res == 0);
  }
}
