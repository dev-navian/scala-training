package io.turntabl
package recursion.warmUp

import org.scalatest.funsuite.AnyFunSuite

class ConcatenateStringTest extends AnyFunSuite {

  // ordinary recursion
  test("Should concatenate string 3 times") {
    val res = ConcatenateString.concatenateString("hi", 3);
    assert(res == "hihihihi")
  }

  test("Should perform no concatenation when 0 is passed as an argument") {
    val res = ConcatenateString.concatenateString("hey", 0);
    assert(res == "hey")
  }

  test("Should return an empty string if an empty string is passed as an argument") {
    val res = ConcatenateString.concatenateString("", 0);
    assert(res == "")
    assert(res != " ")
  }

  // tail recursion
  test("Tail Recursion: Should concatenate string 3 times") {
    val res = ConcatenateString.concatenateStringTailRecursion("hi", 3);
    assert(res == "hihihihi")
  }

  test("Tail Recursion: Should perform no concatenation when 0 is passed as an argument") {
    val res = ConcatenateString.concatenateStringTailRecursion("hey", 0);
    assert(res == "hey")
  }

  test("Tail Recursion: Should return an empty string if an empty string is passed as an argument") {
    val res = ConcatenateString.concatenateStringTailRecursion("", 0);
    assert(res == "")
    assert(res != " ")
  }

}
