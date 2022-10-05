//package io.turntabl
//package functions.warmedUp
//
//import java.io.File
//import scala.annotation.tailrec
//import scala.util.chaining.scalaUtilChainingOps
//
//object FileMatcher {
//
//  def main(args: Array[String]): Unit = {
//    println(filesHere.mkString("Array(", ", ", ")"))
//
////    println( filesEnding("t").mkString("Array(", ", ", ")") )
////    println( fileMatching("md").mkString("Array(", ", ", ")") )
//    println( fileMatchingCurried("(.*)it(.*)")(filesRegex)(filesContainingForCurried).mkString("Array(", ", ", ")") )
//    println( filesRegex("(.*)ea(.*)").mkString("Array(", ", ", ")") )
//  }
//
//  private def filesHere: Array[File] = new File(".").listFiles()
//
//  def fileMatching(query: String): Array[File] = {
//    filesHere.filter(file => file.getName.matches(query) || file.getName.contains(query))
//  }
//
//  def filesEnding(query: String): Array[File] = {
//    filesHere.filter(file => file.getName.endsWith(query))
//  }
//
//
//  def filesContaining(query: String): Array[File] = {
//    filesHere.filter(file => file.getName.contains(query))
//  }
//
//  def filesContainingForCurried(query: String, arg: Array[File]): Array[File] = {
////    println("args...", arg.mkString("Array(", ", ", ")"))
//    val res = arg.filter(file => file.getName.contains(query))
////    println("res", res.mkString("Array(", ", ", ")"))
//    res
//  }
//
//
//  def filesRegex(query: String): Array[File] = {
//    filesHere.filter(file => file.getName.matches(query))
//  }
//
//  def fileMatchingCurried(query: String)(regexOp: String => Array[File])(containingOrEndingOp: (String, Array[File]) => Array[File]): Array[File] = {
//      if (regexOp(query).isEmpty) {
//        containingOrEndingOp(query, filesHere)
//      } else {
//        regexOp(query)
//        containingOrEndingOp(query, filesHere)
//      }
//
//  }
//
//
////  def filesComplexLookup(query: String): Array[File] = fileMatching(query) {
////    (fileName, queryString) => {
////      fileName.length < 5 && fileName.equalsIgnoreCase(queryString) && queryString.charAt(1) == 's'
////    }
////  }
//
//  def filesEnding(query:String): Array[File] = fileMatching(query: String)(_ endsWith _)
//
//
//  def filesMatching(func: (String, String) => Boolean): Function[String,Array[File]] = {
//    @tailrec
//    def filesMatchingAcc(query: String)(fileArray: Array[File], accFileArray: Array[File]): Array[File] = {
//      if(fileArray.isEmpty) accFileArray
//      else filesMatchingAcc(query)(fileArray.tail,
//        if(func(fileArray.head.getAbsolutePath, query)) accFileArray :+ fileArray.head
//        else accFileArray
//      )
//    }
//    (query: String) => filesMatchingAcc(query)(filesHere, Array())
//  }
//
//
////  def endWithMatching: String => Array[File] = filesMatching(_ endsWith _)
////  val startWithMatching = filesMatching(_ startsWith _)
////  val containsMatching = filesMatching(_ contains _)
////  val regexMatching = filesMatching(_ matches _)
////  endWithMatching("") foreach println
////  startWithMatching("") foreach println
////  containsMatching("") foreach println
////  regexMatching("")
//
//
//
//
//
//}
