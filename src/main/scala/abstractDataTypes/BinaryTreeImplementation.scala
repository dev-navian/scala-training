package io.turntabl
package abstractDataTypes

import scala.annotation.tailrec

// trait with contravariance behaviour
sealed trait BinaryTree[+T] {
  def value: T
  def left: BinaryTree[T]
  def right: BinaryTree[T]
  def hasChildren: Boolean
  def size: Int
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](f: T => B): BinaryTree[B]
  def forEach[S >: T](f: S => Unit): Unit
  def reduce[S >: T](f: (S, S) => S): S
  def max: Int
  def depth: Int
}

// an empty node has no value
case object EmptyNode extends BinaryTree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException("Error accessing the value of an empty node")

  override def left: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the left node of an empty node")

  override def right: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the right node of an empty node")

  override def hasChildren: Boolean = false

  override def size: Int = 0

  override def printElements: String = ""

  override def map[B](f: Nothing => B): BinaryTree[B] = EmptyNode

  override def forEach[S >: Nothing](f: S => Unit): Unit = throw new NoSuchElementException("Cannot perform a forEach on an empty node")

  override def reduce[S >: Nothing](f: (S, S) => S): S = throw new NoSuchElementException("Cannot perform a reduce on an empty node")

  override def max: Int = 0

  override def depth: Int = 0
}

// a childless node is also known as a leaf. it only has a value
case class Leaf[T](v: T) extends BinaryTree[T] {
  override def value: T = v

  override def left: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the left child of a leaf")

  override def right: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the right child of a leaf")

  override def hasChildren: Boolean = false

  override def size: Int = 1

  override def printElements: String = v.toString

  override def map[B](f: T => B): BinaryTree[B] = Leaf(f(value))

  override def forEach[S >: T](f: S => Unit): Unit = f(value)

  override def reduce[S >: T](f: (S, S) => S): S = value

  override def max: Int = ???

  override def depth: Int = 0

//  override def max: Int = value match {
//    case Int => value
//    case _ => throw new Exception("Cannot perform a max on a non-integer tree")
//   }
}

// a branch has a left child node and a right child node
case class Branch[T](l: BinaryTree[T], r: BinaryTree[T]) extends BinaryTree[T] {
  override def value: Nothing = throw new NoSuchElementException("No value for a branch")

  override def left: BinaryTree[T] = l

  override def right: BinaryTree[T] = r

  override def hasChildren: Boolean = true

  override def size: Int = left.size + right.size

  override def printElements: String = left.printElements + ", " + right.printElements

  override def map[B](f: T => B): Branch[B] = Branch(left.map(f), right.map(f))

  override def forEach[S >: T](f: S => Unit): Unit = {
    left.forEach(f)
    right.forEach(f)
  }

  override def reduce[S >: T](f: (S, S) => S): S = f(left.reduce(f), right.reduce(f))

  override def max: Int= {

    if (left.max > right.max) left.max
    else right.max
//    def maxAcc(x: Leaf[Int], y: Leaf[Int]): Int =
//
//      if (x.value > y.value) {
//        x.value
////        x.reduce()
//
//      }

//    left.reduce(max)
  }

  override def depth: Int = {
    val leftDepth = 1 + left.depth
    val rightDepth = 1 + right.depth

    if (leftDepth > rightDepth) leftDepth
    else rightDepth
  }

}

object BinaryTree {

  def main(args: Array[String]): Unit = {
    val treeOne = Branch(
      Branch(Leaf(2), Branch(Leaf(4), Leaf(12))),
      Branch(Branch(Leaf(6), Leaf(8)), Branch(Leaf(10), Branch(Leaf(14), Leaf(16))))
    )

    println(s"treeOne: $treeOne")
    println()

    val reduced = treeOne.reduce(_ + _)
    println(reduced)

//    val maxed = treeOne.max
//    println(s"maxed $maxed")

    val depthed = treeOne.depth
    println(s"depth: $depthed")
  }

}