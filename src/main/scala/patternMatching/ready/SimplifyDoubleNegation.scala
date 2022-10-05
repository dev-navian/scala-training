package io.turntabl
package patternMatching.ready
//
//
object SimplifyDoubleNegation {
//
  sealed trait Expression
  case class Variable(name: String) extends Expression
  case class Number(number: Double) extends Expression
  case class UnaryOperation(operator: String, argument: Expression) extends Expression
  case class BinaryOperation(operator: String, left: Expression, right: Expression) extends Expression
//
//  def main(args: Array[String]): Unit = {
//    val argument = UnaryOperation("-", Number(2.3))
//    val simp = simplify(argument)
//
//    println(simp)
//  }
//
//  def simplify(expr: Expression): Expression = {
//
////    expr match {
////      case UnaryOperation(o, a) => {
////        case (o: String, a: Double) => {
////          def guessOperator(op: String, a: Double): Double = {
////            op match {
////              case "-" => -a
////              case "+" => +a
////            }
////          }
////          guessOperator(o, a)
////          }
////      }
//    }
//  }
//
}
