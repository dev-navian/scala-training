
sealed trait MyLinkedList[+T] {
  def head: T
  def tail: MyLinkedList[T]
  def isEmpty: Boolean
  def ::[S >: T](element: S): MyLinkedList[S] // Add method
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

case object Empty extends MyLinkedList[Nothing] {
  override def head = throw new NoSuchElementException("Head of an empty linked list")

  override def tail = throw new NoSuchElementException("Attempt to access the tail of the linked list")

  override def isEmpty = true

  override def ::[S >: Nothing](element: S) = Cons(element, Empty)

  override def printElements: String = ""
}

case class Cons[T](h: T, t: MyLinkedList[T]) extends MyLinkedList[T] {
  override def head = h

  override def tail = t

  override def isEmpty: Boolean = false

  override def ::[S >: T](element: S): MyLinkedList[S] = Cons(element, this)

  override def printElements =
    if (t.isEmpty) head.toString
    else head.toString + ", " + tail.printElements
}

/**

 def apply[T](items: T*): MyLinkedList[T] = {
    if (items.length == 1) Cons(items.head, Empty)

    else (items.head :: apply(....................

**/