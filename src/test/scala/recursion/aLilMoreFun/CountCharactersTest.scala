package io.turntabl
package recursion.aLilMoreFun

import org.scalatest.funsuite.AnyFunSuite

class CountCharactersTest extends AnyFunSuite {

  // tail recursion
  test("Returns a Map of the characters in 'hello' and the times the various characters appear") {
    val res = CountCharacters.countCharactersTailRecursively("hello");
    val expected: Map[Char, Int] = Map('h' -> 1, 'e' -> 1, 'l' -> 2, 'o' -> 1);

    assert(res.equals(expected))
  }

  test("Returns a Map of the characters in 'mongoose' and the times the various characters appear") {
    val res = CountCharacters.countCharactersTailRecursively("mongoose");
    val expected: Map[Char, Int] = Map('m' -> 1, 'o' -> 3, 'n' -> 1, 'g' -> 1, 's' -> 1, 'e' -> 1);

    assert(res.equals(expected))
  }

  test("Returns a Map of no characters and values for an empty string") {
    val res = CountCharacters.countCharactersTailRecursively("");
    val expected: Map[Char, Int] = Map();

    assert(res.equals(expected))
  }

}
