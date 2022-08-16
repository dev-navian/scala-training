package io.turntabl
package functions.warmedUp

import java.io.File
import scala.util.chaining.scalaUtilChainingOps

object FileMatcher {

  def main(args: Array[String]): Unit = {
    println(filesHere.mkString("Array(", ", ", ")"))

//    println( filesEnding("t").mkString("Array(", ", ", ")") )
//    println( fileMatching("md").mkString("Array(", ", ", ")") )
    println( fileMatchingCurried("(.*)it(.*)")(filesRegex)(filesContainingForCurried).mkString("Array(", ", ", ")") )
    println( filesRegex("(.*)it(.*)").mkString("Array(", ", ", ")") )
  }

  private def filesHere: Array[File] = new File(".").listFiles()

  def fileMatching(query: String): Array[File] = {
    filesHere.filter(file => file.getName.matches(query) || file.getName.contains(query))
  }

  def filesEnding(query: String): Array[File] = {
    filesHere.filter(file => file.getName.endsWith(query))
  }


  def filesContaining(query: String): Array[File] = {
    filesHere.filter(file => file.getName.contains(query))
  }

  def filesContainingForCurried(query: String, arg: Array[File]): Array[File] = {
//    println("args...", arg.mkString("Array(", ", ", ")"))
    val res = arg.filter(file => file.getName.contains(query))
//    println("res", res.mkString("Array(", ", ", ")"))
    res
  }


  def filesRegex(query: String): Array[File] = {
    filesHere.filter(file => file.getName.matches(query))
  }

  def fileMatchingCurried(query: String)(regexOp: String => Array[File])(containingOrEndingOp: (String, Array[File]) => Array[File]): Array[File] = {
      if (regexOp(query).isEmpty) {
        containingOrEndingOp(query, filesHere)
      } else {
        regexOp(query)
        containingOrEndingOp(query, filesHere)
      }

  }

}
