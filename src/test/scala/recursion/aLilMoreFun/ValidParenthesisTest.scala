package io.turntabl
package recursion.aLilMoreFun

import org.scalatest.funsuite.AnyFunSuite

class ValidParenthesisTest extends AnyFunSuite {

  // tail recursion
  test("the string '()' is a valid parenthesis") {
    val res = ValidParenthesis.hasValidParenthesisTailRecursion("()");
    assert(res)
  }

  test("the string '((()))' is a valid parenthesis") {
    val res = ValidParenthesis.hasValidParenthesisTailRecursion("((()))");
    assert(res)
  }

  test("the string '(()' is not a valid parenthesis") {
    val res = ValidParenthesis.hasValidParenthesisTailRecursion("(()");
    assert(!res)
  }

  test("the string '(' is not a valid parenthesis") {
    val res = ValidParenthesis.hasValidParenthesisTailRecursion("(");
    assert(!res)
  }
}
