package io.turntabl
package patternMatching.ready

object ShowMath {

  sealed trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr
  case class Div(e1: Expr, e2: Expr) extends Expr

  def show(expr: Expr): String = {
      expr match {
        case Number(n) => s"$n"
        case Sum(a, b) => show(a) + " + " + show(b)
        case Prod(c, d) => {
          def addParenthesis(expr: Expr): String = {
            expr match {
              case Prod(_, _) => show(expr)
              case Number(_) => show(expr)
              case _ => "(" + show(expr) + ")"
            }
          }
          addParenthesis(c) + " * " + addParenthesis(d)
        }
        case Div(g, h) => {
          def addParenthesis(expr: Expr): String = {
            expr match {
              case Number(_) => show(expr)
              case _ => "(" + show(expr) + ")"
            }
          }
          addParenthesis(g) + " / " + addParenthesis(h)
        }
        case _ => "wrong argument"
      }

    }

}
