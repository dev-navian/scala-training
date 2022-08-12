package io.turntabl
package functions.warmUp

object QuestionOne {

  val findLengthOfStringLongHand = new Function5[String, String, String, String, String, Int] {
    def apply(a: String, b: String, c: String, d: String, e: String): Int = a.length + b.length + c.length + d.length + e.length
  }

  val findTheLengthOfStringShorthand: (String, String, String, String, String) => Int = (a: String, b: String, c: String, d: String, e: String) => a.length + b.length + c.length + d.length + e.length

  // WHICH DO I PREFER?
  // the second one (shorthand) because the syntax is easy to read and understand as compared to the former
}
