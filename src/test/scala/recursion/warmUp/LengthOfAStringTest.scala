package io.turntabl
package recursion.warmUp

import org.scalatest.funsuite.AnyFunSuite

class LengthOfAStringTest extends AnyFunSuite {

  // ordinary validation
  test("The length of the string 'hello' is 5") {
    val res = LengthOfAString.findTheLengthOfAString("hello");
    assert(res == 5);
  }

  test("The length of an empty string is 0") {
    val res = LengthOfAString.findTheLengthOfAString("");
    assert(res == 0);
    assert(res != 1);
  }

  test("The length of the string is 'hi' is 2") {
    val res = LengthOfAString.findTheLengthOfAString("hi");
    assert(res == 2);
  }

  // tail recursion
  test("Tail Recursion: The length of the string 'hello' is 5") {
    val res = LengthOfAString.findTheLengthOfAStringTailRecursively("hello");
    assert(res == 5);
  }

  test("Tail Recursion: The length of an empty string is 0") {
    val res = LengthOfAString.findTheLengthOfAStringTailRecursively("");
    assert(res == 0);
    assert(res != 1);
  }

  test("Tail Recursion: The length of the string is 'a' is 1") {
    val res = LengthOfAString.findTheLengthOfAStringTailRecursively("a");
    assert(res == 1);
  }
}
