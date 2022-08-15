package io.turntabl
package functions.warmUp

object QuestionFour {

//  Convert the following function in to a curried version and provide an example of
//  calling both the curried and uncurried version of the function

  def main(args: Array[String]): Unit = {
    val resultOne = addThreeNumbers(10, 10, 20);
    println(resultOne)

    val resultTwo = curriedAddThreeNumbers(10)(10)(20)
    println(resultTwo)

    val resultThree = curriedAddThreeNumbersMethod(10)(10)(20)
    println(resultTwo)

  }

  val addThreeNumbers: (Int, Int, Int) => Int = (x: Int, y: Int, z: Int) => x + y + z

  val curriedAddThreeNumbers: Int => Int => Int => Int = x => y => z => x + y + z

  def curriedAddThreeNumbersMethod(a: Int)(b: Int)(c: Int): Int = a + b + c
}
