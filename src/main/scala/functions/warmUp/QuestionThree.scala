package io.turntabl
package functions.warmUp

object QuestionThree {

  def main(args: Array[String]): Unit = {
    val num: Int = 4
    val str: String = "hello";

//    lengthOfStringOneTimesNTimesTheLengthOfStringTwo(str, gReturnInt(nTimesTheLengthOfString(num, lengthOfAString(str))))
  }

  //  val function: (String, (Int, (String => Int)) => Int) => (Int => Int)

  // The above type signature indicates a function which has two arguments: the first being a string, and the other being
  // a function returning an integer, which accepts an integer as an argument, and another argument function which accepts a string as an argument
  // and returns an integer. The function then returns another function which accepts an integer as argument and returns
  // another integer.

//  def lengthOfAString(func: String => Int): String => Int = func

//  def lengthOfAString(str: String): String => Int = (str) => str.length

  val double: Int => Int = (i: Int) => i * 2

  val lengthOfString: String => Int = (str: String) => str.length

  val multiplyLengthOfStringNTimes: (Int, String => Int) => Int = (num: Int, func: String => Int) => num * func

  val someFunc = (str: String, fn: (Int, String => Int) => Int) => (fn , str.length)

//  def lengthOfAString(str: String): Int = str.length
//
//  def nTimesTheLengthOfString(num: Int, func: String => Int): Int = num * func("hello")
//
//  def gReturnInt(num: Int): Int = num * 2

//  def lengthOfStringOneTimesNTimesTheLengthOfStringTwo(str: String, fcn: (Int, String => Int) => Int): (Int => Int) = (str.length) => gReturnInt(nTimesTheLengthOfString(lengthOfAString(str), fcn))


}
