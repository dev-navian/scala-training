package io.turntabl
package functions.warmUp

import org.scalatest.funsuite.AnyFunSuite

class QuestionFourTest extends AnyFunSuite {

  test("Non-curried: the sum of 2, 3 and 4 is 9") {
    val res = QuestionFour.addThreeNumbers(2, 3, 4)
    assert(res == 9)
  }

  test("Non-curried: the sum of 0, 0 and 0 is 0") {
    val res = QuestionFour.addThreeNumbers(0, 0, 0)
    assert(res == 0)
  }

  test("Non-curried: the sum of 10, 10 and 10 is 30") {
    val res = QuestionFour.addThreeNumbers(10, 10, 10)
    assert(res == 30)
  }

  // curried functions
  test("Curried Function: the sum of 2, 3 and 4 is 9") {
    val res = QuestionFour.curriedAddThreeNumbers(2)(3)(4)
    assert(res == 9)
  }

  test("Curried Function: the sum of 0, 0 and 0 is 0") {
    val res = QuestionFour.curriedAddThreeNumbers(0)(0)(0)
    assert(res == 0)
  }

  test("Curried Function: the sum of 10, 10 and 10 is 30") {
    val res = QuestionFour.curriedAddThreeNumbers(10)(10)(10)
    assert(res == 30)
  }

  // curried methods
  test("Curried Method: the sum of 2, 3 and 4 is 9") {
    val res = QuestionFour.curriedAddThreeNumbersMethod(2)(3)(4)
    assert(res == 9)
  }

  test("Curried Method: the sum of 0, 0 and 0 is 0") {
    val res = QuestionFour.curriedAddThreeNumbersMethod(0)(0)(0)
    assert(res == 0)
  }

  test("Curried Method: the sum of 10, 10 and 10 is 30") {
    val res = QuestionFour.curriedAddThreeNumbersMethod(10)(10)(10)
    assert(res == 30)
  }

}
