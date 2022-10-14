package io.turntabl
package abstractDataTypes

// trait with contravariance behaviour
sealed trait BinaryTree[+T] {
  def value: T
  def left: BinaryTree[T]
  def right: BinaryTree[T]
  def size: Int
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](f: T => B): BinaryTree[B]
  def forEach[S >: T](f: S => Unit): Unit
  def reduce[S >: T](f: (S, S) => S): S
}

// a childless node is also known as a leaf. it only has a value
case class Leaf[T](v: T) extends BinaryTree[T] {
  override def value: T = v

  override def left: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the left child of a leaf")

  override def right: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the right child of a leaf")

  override def size: Int = 1

  override def printElements: String = v.toString

  override def map[B](f: T => B): BinaryTree[B] = Leaf(f(value))

  override def forEach[S >: T](f: S => Unit): Unit = f(value)

  override def reduce[S >: T](f: (S, S) => S): S = value
}

// a branch has a left child node and a right child node
case class Branch[T](l: BinaryTree[T], r: BinaryTree[T]) extends BinaryTree[T] {
  override def value: Nothing = throw new NoSuchElementException("No value for a branch")

  override def left: BinaryTree[T] = l

  override def right: BinaryTree[T] = r

  override def size: Int = left.size + right.size

  override def printElements: String = left.printElements + ", " + right.printElements

  override def map[B](f: T => B): Branch[B] = Branch(left.map(f), right.map(f))

  override def forEach[S >: T](f: S => Unit): Unit = {
    left.forEach(f)
    right.forEach(f)
  }

  override def reduce[S >: T](f: (S, S) => S): S = f(left.reduce(f), right.reduce(f))
}

object BinaryTree {

  def main(args: Array[String]): Unit = {

  }

}