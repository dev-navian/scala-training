package io.turntabl
package linkedList

import scala.annotation.tailrec

// trait with covariance behaviour
sealed trait SomeLinkedList[+T] {
  def head: T
  def tail: SomeLinkedList[T]
  def isEmpty: Boolean
  def ::[S >: T](element: S): SomeLinkedList[S]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def length: Int
  def map[B](f: (T => B)): SomeLinkedList[B]
  def flatMap[B](f: T => SomeLinkedList[B]): SomeLinkedList[B]
  def forEach(f: T => Unit): Unit
  def filter(f: T => Boolean): SomeLinkedList[T]

  def fold[S >: T](start: S)(operator: (S, S) => S): S
  def ++[S >: T](list: SomeLinkedList[S]): SomeLinkedList[S]
  def reverse: SomeLinkedList[T]
  def reduce[S >: T](operator: (S, S) => S): S

  def zip[S](list: SomeLinkedList[S]): SomeLinkedList[(T,S)]
  def zipWith[R, S](list: SomeLinkedList[R], zip:(T,R) => S): SomeLinkedList[S]
  def zipWithIndex: SomeLinkedList[(T, Int)]

}

case object EmptyList extends SomeLinkedList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException("Error accessing the head of the linked list")

  override def tail: Nothing = throw new NoSuchElementException("Error accessing the tail of the linked list")

  override def isEmpty: Boolean = true

  override def ::[S >: Nothing](element: S): SomeLinkedList[S] = NonEmptyList(element, EmptyList)

  override def printElements: String = ""

  override def length: Int = 0

  override def map[B](f: Nothing => B): SomeLinkedList[B] = throw new NoSuchElementException("Cannot perform map on an empty list")

  override def flatMap[B](f: Nothing => SomeLinkedList[B]): SomeLinkedList[B] = EmptyList

  override def forEach(f: Nothing => Unit): Unit = throw new NoSuchElementException("Cannot perform forEach on an empty list")

  override def filter(f: Nothing => Boolean): SomeLinkedList[Nothing] = EmptyList

  override def ++[S >: Nothing](list: SomeLinkedList[S]): SomeLinkedList[S] = EmptyList

  override def reverse: SomeLinkedList[Nothing] = EmptyList

  override def fold[S >: Nothing](start: S)(operator: (S, S) => S): S = start

  override def reduce[S >: Nothing](operator: (S, S) => S): S = throw new NoSuchElementException("Cannot perform reduce on an empty linked list")

  override def zip[S](list: SomeLinkedList[S]): SomeLinkedList[(Nothing, S)] = EmptyList

  override def zipWithIndex: SomeLinkedList[(Nothing, Int)] = EmptyList

  override def zipWith[R, S](list: SomeLinkedList[R], zip: (Nothing, R) => S): SomeLinkedList[S] = EmptyList
}

case class NonEmptyList[T](h: T, t: SomeLinkedList[T]) extends SomeLinkedList[T] {
  override def head: T = h

  override def tail: SomeLinkedList[T] = t

  override def isEmpty: Boolean = false

  override def ::[S >: T](element: S): SomeLinkedList[S] = NonEmptyList(element, this)

  override def printElements: String =
    if (tail.isEmpty) head.toString
    else head.toString + ", " + tail.printElements

  override def length: Int = 1 + tail.length

  override def map[B](f: T => B): SomeLinkedList[B] = f(head) :: tail.map(f)

  override def flatMap[B](f: T => SomeLinkedList[B]): SomeLinkedList[B] = f(head) ++ tail.flatMap(f)

  override def forEach(f: T => Unit): Unit = {
    f(head)
    tail.forEach(f)
  }

  override def filter(f: T => Boolean): SomeLinkedList[T] =
    if (f(head)) head :: tail.filter(f)
    else tail.filter(f)

  override def ++[S >: T](list: SomeLinkedList[S]): SomeLinkedList[S] = NonEmptyList(h, t ++ list)

  override def reverse: SomeLinkedList[T] = {
    @tailrec
    def reverseAcc(currList: SomeLinkedList[T], reversedList: SomeLinkedList[T]): SomeLinkedList[T] = {
      if (currList.isEmpty) reversedList
      else reverseAcc(currList.tail, currList.head :: reversedList)
    }

    reverseAcc(this, EmptyList)
  }

  override def fold[S >: T](start: S)(operator: (S, S) => S): S =
    if (isEmpty) start
    else tail.fold(operator(start, head))(operator)

  override def reduce[S >: T](operator: (S, S) => S): S =
    if (length < 2) head
    else tail.tail.fold(operator(head, tail.head))(operator)

    /*
      x = List(1, 2, 3, 4, 5)
      y = List(a, b, c, d, e, f,)
      x.zip(y) = List((1, a), (2, b), (3, c), (4, d), (5, e))
     */
  override def zip[S](list: SomeLinkedList[S]): SomeLinkedList[(T, S)] = {
    if (list.isEmpty) EmptyList
    else (head, list.head) :: tail.zip(list.tail)
  }

  override def zipWith[R, S](list: SomeLinkedList[R], zip: (T, R) => S): SomeLinkedList[S] =
    if (list.isEmpty) EmptyList
    else zip(head, list.head) :: tail.zipWith(list.tail, zip)

  override def zipWithIndex: SomeLinkedList[(T, Int)] = {
    val indexes = 0 until(this.length)

    val indexesAsList = SomeLinkedList(indexes :_*)

    this.zip(indexesAsList)
  }

}

object SomeLinkedList {

  def apply[T](items: T*): SomeLinkedList[T] = {
    if (items.isEmpty) EmptyList
    else NonEmptyList(items.head, apply(items.tail :_*))
  }

  def main(args: Array[String]): Unit = {
    val firstImplementation: SomeLinkedList[Int] = NonEmptyList(1, NonEmptyList(2, NonEmptyList(3, NonEmptyList(4, EmptyList))))

    val emptyLinkedList = EmptyList
    val listIsEmpty = emptyLinkedList.isEmpty
//    println(listIsEmpty)

    val anotherLinkedList: SomeLinkedList[Int] = 45 :: 22 :: 33 :: 77 :: EmptyList
//    println(anotherLinkedList)

    val ownListImplementation: SomeLinkedList[Int] = SomeLinkedList(2, 3, 4, 5, 6, 7, 8, 9)
//    println(ownListImplementation)
//    println(s"length is => ${ownListImplementation.length}")

    val justOne: SomeLinkedList[Int] = 2000 :: 4000 :: 5550 :: EmptyList
//    println(justOne.length)

//    justOne.forEach(e => println("hello" + e))
    val mapped = ownListImplementation.map(e => e * e)
//    println(mapped)


  }

}

