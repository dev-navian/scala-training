package io.turntabl
package recursion.aLilMoreFun

import scala.annotation.tailrec

object CountCharacters extends App {

  def countCharacters(s: String): Map[Char, Int] = {
    Map()
  }

  def countCharactersTailRecursively(s: String): Map[Char, Int] = {

    @tailrec
    def countCharacters(s: String, index: Int, map: Map[Char, Int]): Map[Char, Int]  = {
      if (index == s.length) map

      else {
        if (map.contains(s.charAt(index))) {
          val newMap = map.updatedWith(s.charAt(index)) { case Some(value) => Some(value + 1) case None => None }
          countCharacters(s, index + 1, newMap)
        }
        else countCharacters(s, index + 1, map + (s.charAt(index) -> 1))
      }
    }

    countCharacters(s, 0, Map());
  }

}
