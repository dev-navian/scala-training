package io.turntabl
package functions.warmUp

import org.scalatest.funsuite.AnyFunSuite

class QuestionTwoTest extends AnyFunSuite {
  def squareNum(num: Int): Int => Int = (num) => num * num

  test("square of 2 is 4") {
    val res = QuestionTwo.squareNumber(2, squareNum(3));
    assert(res == 4);
    assert(res.isValidInt);
  }

  test("square of 1 is 1") {
    val res = QuestionTwo.squareNumber(1, squareNum(1));
    assert(res == 1);
    assert(res != 2);
  }

  test("square of 16 is 256") {
    val res = QuestionTwo.squareNumber(16, squareNum(1));
    assert(res == 256);
    assert(res.isValidInt);
  }

}
