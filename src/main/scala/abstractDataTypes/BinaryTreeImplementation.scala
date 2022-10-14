package io.turntabl
package abstractDataTypes

import scala.annotation.tailrec

// trait with contravariance behaviour
sealed trait BinaryTree[+T] {
  def value: T
  def left: BinaryTree[T]
  def right: BinaryTree[T]
  def size: Int
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](f: T => B): BinaryTree[B]
  def reduce[S >: T](f: (S, S) => S): S
  def forEach[S >: T](f: S => Unit): Unit
}

// a childless node is also known as a leaf
case class Leaf[T](v: T) extends BinaryTree[T] {
  override def value: T = v

  override def left: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the left child of a leaf")

  override def right: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the right child of a leaf")

  override def size: Int = 1

  override def printElements: String = v.toString

  override def map[B](f: T => B): BinaryTree[B] = Leaf(f(value))

  override def reduce[S >: T](f: (S, S) => S): S = value

  override def forEach[S >: T](f: S => Unit): Unit = f(value)
}

// a branch has is made up of three parts: the element itself, a left child node and a right child node
case class Branch[T](v: T, l: BinaryTree[T], r: BinaryTree[T]) extends BinaryTree[T] {
  override def value: T = v

  override def left: BinaryTree[T] = l

  override def right: BinaryTree[T] = r

  override def size: Int = 1 + l.size + r.size

  override def printElements: String =
    v.toString + ", " + l.printElements + ", " + r.printElements

  override def map[B](f: T => B): Branch[B] = Branch(f(value), left.map(f), right.map(f))

  override def reduce[S >: T](f: (S, S) => S): S = {


//    def reduceAcc(node: BinaryTree[T], f: S => S, acc: S): S = node match {
//      case Leaf(v) => f(v)
//      case Branch(v, l, _) => reduceAcc(l, f, v) + reduceAcc(r, f, _)
//    }

//    reduceAcc(this, value)
  }

  override def forEach[S >: T](f: S => Unit): Unit = {
    f(value)
    left.forEach(f)
    right.forEach(f)
  }
}

object BinaryTree {

  def main(args: Array[String]): Unit = {
    val treeOne: Branch[Int] = Branch(
      2,
      Branch(4, Branch(6, Leaf(8), Leaf(10)), Leaf(11)),
      Branch(13, Branch(15, Leaf(18), Leaf(20)), Leaf(22))
    )
    println(s"treeOne : $treeOne")

    val mapped = treeOne.map(_ * 2)
//    println(s"mapped : $mapped")

    val reduced = treeOne.reduce((a, b) => a + b)
    println(s"reduced: $reduced")

//    treeOne.forEach(a => println(s"printing... $a"))
  }

}