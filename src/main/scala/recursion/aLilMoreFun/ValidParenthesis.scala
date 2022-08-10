package io.turntabl
package recursion.aLilMoreFun

import scala.annotation.tailrec
import scala.collection.mutable

object ValidParenthesis extends App {

  def hasValidParenthesisTailRecursion(s: String): Boolean = {

    @tailrec
    def checkValidParenthesis(s: String, index: Int, map: Map[Char, Char], temp: mutable.Stack[Char]): Boolean = {

      if (index == s.length) {
        if (temp.isEmpty) true;
        else false;
      }
      else {
        // get the value of the character at the current index
        val charAtCurrentIndex = s.charAt(index)
        // if the map contains the value of the current character as a key
        if (map.contains(charAtCurrentIndex)) {
          // if yes, push the key's value to the stack and call the function again
          temp.push(map(charAtCurrentIndex))
          checkValidParenthesis(s, index + 1, map, temp);

          // if it does not contain the value, it should have been pushed to the stack
          // check if the stack is not empty, and that the last element matches the current char
        } else if (temp.nonEmpty && temp.pop() == charAtCurrentIndex) {
          checkValidParenthesis(s, index + 1, map, temp);
          // else just call the function again
        } else checkValidParenthesis(s, index + 1, map, temp);
      }

    }

    checkValidParenthesis(s, 0, Map('(' -> ')'), mutable.Stack[Char]());
  }
}
