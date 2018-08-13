package one.dev

import scala.io.{BufferedSource, Source}

/**
  * @Description:
  * @Date 下午6:11 2018/8/8
  * @Author: joker
  */
object test {

  def main(args: Array[String]): Unit = {
    /*val array = Array("i", "love", "you")
    array.foreach(print)*/

    //set map
    /*val s1 = Set(1, 2, 3)
    val m1 = Map(1 -> "i", 2 -> "love", 3 -> "you")*/

    val a = 2
    val b = 2
    a.toLong
  }

  def printArray(array: Array[String]): Unit = {
    array.foreach(println)
  }

  def none(): Unit = {
    for (i <- 0.to(10) if i % 2 ==0) {
      println(i)
    }
    val arrs = new Array[String](3)
    arrs(0) = "asf"
    println("     " + arrs(0))

    val arrs2 = Array(1, 2)
  }

  def list(): Unit = {
    val list1 = List(1, 2)
    val list2 = List(3, 4)

    val list12 = list1 ::: list2

    println(list12)

    val list3 = 1 :: 2 :: 3 :: Nil

    val list4 = Nil.::(3).::(2).::(1)

    println(list3)
    println(list4)

    //head、last、length、reverse、tail

    println(list4.head)
    println(list4.last)
    println(list4.length)
    println(list4.reverse)
    println(list4.tail)
  }

  def tuple(): Unit = {
    val t1 = (1, "ding yi")
    println(t1)
    println(t1._1)
    println(t1._2)
  }

  def file(): Unit = {
    val lines: BufferedSource = Source.fromFile("/opt/tree.txt")
    for (line <- lines.getLines()) {
      println(line)
    }
  }

}
