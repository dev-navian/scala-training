
// GENERIC MERGE SORT FUNCTION
def msort[T](compare:(T,T) => Boolean)(xs: List[T]): List[T] = {

  def merge(xs:List[T], ys: List[T]): List[T] = {

    (xs, ys) match {
      case (_, Nil) => xs

      case (Nil, _) => ys

      case(xHead :: xTail, yHead :: yTail) =>
        if ( compare(xHead, yHead) ) xHead :: merge(xTail, ys)
        else yHead :: merge(xs, yTail)
    }

  }

  val n = xs.length / 2
  if (n == 0) xs
  else {
    val(ys,zs) = xs.splitAt(n)
    merge(msort(compare)(ys), msort(compare)(zs))
  }

}

msort[Int](_ < _)(List(100, 23, 2, 656, 41, 8))

val intSort: List[Int] => List[Int] = msort(_ < _)
val reverseIntSort: List[Int] => List[Int] = msort(_ > _)

//intSort(,9,3,5,1)

intSort( List(9,3,5,1) )
reverseIntSort( List(9,3,5,1) )
