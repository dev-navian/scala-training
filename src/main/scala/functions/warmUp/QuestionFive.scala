package io.turntabl
package functions.warmUp

import scala.:+
import scala.annotation.tailrec

object QuestionFive {

  def main(args: Array[String]): Unit = {

//    val res = concatenateStringRecursive("friend", "friend")
//    println(res)

//    val res = concatenate(param1, param2, concat())

  }

  def concatenate[T](item: T, item2: T, concat: (T, T) => T): T = concat(item, item2)


//  def concat[T](argOne: T, argTwo: T): T = {
//
//    @tailrec
//    def conc[T](item: IndexedSeq[T], index: Int = 0, acc: String = ""): String = {
//      if (index == item.length) acc
//      conc(item, index + 1, acc + item.apply(index))
//    }
//
//    conc(argOne :+ argTwo);
//  }



//  def concatenateStringRecursive(stringOne: String, stringTwo: String): String = {
//    @tailrec
//    def concatenateString(strOne: String, strTwo: String): String = {
//      if (strOne.isEmpty) return strTwo
//      concatenateString("", strOne + stringTwo)
//    }
//
//    concatenateString(stringOne, stringTwo)
//  }
}
