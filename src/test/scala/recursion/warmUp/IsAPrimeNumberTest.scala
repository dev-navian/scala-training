package io.turntabl
package recursion.warmUp

import org.scalatest.funsuite.AnyFunSuite

class IsAPrimeNumberTest extends AnyFunSuite {

  // tail recursion
  test("3 is a prime number") {
    val res = IsAPrimeNumber.isPrimeTailRecursion(3);
    assert(res);
  }

  test("6 is not prime number") {
    val res = IsAPrimeNumber.isPrimeTailRecursion(6);
    assert(!res);
  }

  test("9 is not prime number") {
    val res = IsAPrimeNumber.isPrimeTailRecursion(9);
    assert(!res);
  }

  test("29 is a prime number") {
    val res = IsAPrimeNumber.isPrimeTailRecursion(29);
    assert(res);
  }
}
