package io.turntabl
package patternMatching.ready

import org.scalatest.funsuite.AnyFunSuite

class ShowMathTest extends AnyFunSuite {

  val numTwo: ShowMath.Number = ShowMath.Number(2)
  val numThree: ShowMath.Number = ShowMath.Number(3)
  val numFour: ShowMath.Number = ShowMath.Number(4)
  val numFive: ShowMath.Number = ShowMath.Number(5)

  test("return appropriate string when Number is passed") {
    val res = ShowMath.show(numThree)

    assert(res == "3")
  }

  test("return appropriate string when Sum is passed") {
    val sum = ShowMath.Sum(numTwo, numThree)

    val res = ShowMath.show(sum)
    assert(res == "2 + 3")
  }

  test("return appropriate string when Sum with appropriate arguments are passed") {
    val sumOne = ShowMath.Sum(numTwo, numThree)
    val sumTwo = ShowMath.Sum(sumOne, numFour)

    val res = ShowMath.show(sumTwo)
    assert(res == "2 + 3 + 4")
  }

  test("return appropriate string when Prod with appropriate arguments are passed") {
    val sumOne = ShowMath.Sum(numTwo, numThree)
    val prodOne = ShowMath.Prod(sumOne, numFour)

    val res = ShowMath.show(prodOne)
    assert(res == "(2 + 3) * 4")
  }

  test("return appropriate string when Div with appropriate arguments are passed") {
    val sum = ShowMath.Sum(numTwo, numThree)
    val prod = ShowMath.Prod(sum, numFour)
    val div = ShowMath.Div(prod, numFive)

    val res = ShowMath.show(div)
    assert(res == "((2 + 3) * 4) / 5")
  }

}
