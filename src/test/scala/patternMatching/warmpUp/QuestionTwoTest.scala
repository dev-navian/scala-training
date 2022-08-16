package io.turntabl
package patternMatching.warmpUp

import org.scalatest.funsuite.AnyFunSuite

class QuestionTwoTest extends AnyFunSuite {

  test("An argument of an empty list should return 0") {
    val res = QuestionTwo.listMatcher(List.empty)
    assert(res == 0)
  }

  test("An argument of List(1, 2, 4) should return 4") {
    val argList = List(1, 2, 4)
    val res = QuestionTwo.listMatcher(argList)
    assert(res == 4)
    assert(res != 3)
  }

  test("An argument of List(5, 2, 4, 7, 11) should return 5, which is the head") {
    val argList = List(5, 2, 4, 7, 11)
    val res = QuestionTwo.listMatcher(argList)
    assert(res == 5)
  }
}
