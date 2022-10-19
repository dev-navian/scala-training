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
  def depth: Int
  def fold[B](f: T => B, g: (B, B) => B): B
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

  override def depth: Int = 0

  override def fold[B](f: Nothing => B, g: (B, B) => B): B = throw new NoSuchElementException("Cannot perform a fold on an empty node")
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

  override def depth: Int = 0

//  override def max: Int = this match {
//    case leaf: Leaf[Int] => leaf.value
//    case _ => throw new Exception("Cannot perform a max on a non-integer tree")
//   }

  override def fold[B](f: T => B, g: (B, B) => B): B = f(value)
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

  override def depth: Int = 1 + left.depth max right.depth

  override def fold[B](f: T => B, g: (B, B) => B): B = g(left.fold(f, g), right.fold(f, g))
}

object BinaryTree {

  def maxInt(tree: BinaryTree[Int]): Int = tree.reduce(_ max(_))

  def main(args: Array[String]): Unit = {
    val treeOne = Branch(
      Branch(Leaf(2), Branch(Leaf(4), Leaf(12))),
      Branch(Branch(Leaf(6), Leaf(38)), Branch(Leaf(10), Branch(Leaf(14), Leaf(16))))
    )

    println(s"treeOne: $treeOne")
    println()

    val reduced = treeOne.reduce(_ + _)
    println(reduced)

    val maxed = maxInt(treeOne)
    println(s"maxed $maxed")

    val depthed = treeOne.depth
    println(s"depth: $depthed")
  }

}