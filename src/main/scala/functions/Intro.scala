package io.turntabl
package functions

// NOT PART OF THE EXERCISES
// basic exploration of functions in scala before practicing the exercises
object Intro {

  def main (args: Array[String]): Unit = {
    val res = addition(2, 3)
    println(res)

    val result = higherOrderFunction(divideByTwo, 8)
    println("result...", result)

    val another = hOFTwo(2, 3, addition, divideByTwo)
    println("another...", another)
  }


  val addition: (Int, Int) => Int = (x: Int, y: Int) => x + y

  ////////////////////////////////////////////////////////////////////////////////////////
  val multiplyStuff = new Function3[Int, Int, Int, Int] {
    def apply(a: Int, b: Int, c: Int): Int = (a * b * c)
  }

  ////////////////////////////////////////////////////////////////////////////////////////
  val multiplySome: (Int, Int, Int) => Int = (a: Int, b: Int, c: Int) => a + b + c

  ////////////////////////////////////////////////////////////////////////////////////////
  val shortSyntax: (Int, Int, Int) => Int = _ * _ *  2 + _

  ////////////////////////////////////////////////////////////////////////////////////////
  val divideByTwo: (Int) => Int = (x: Int) => x / 2

  ////////           higher order functions
  def higherOrderFunction(f: Int => Int, x: Int): Int = f(x)

  def hOFTwo(a: Int, b: Int, f: (Int, Int) => Int, g: Int => Int): Int = f(a, b) + g(b)

}
