package one.dev

import scala.io.Source

/**
  * @Description:
  * @Date 下午4:23 2018/8/10
  * @Author: joker
  */
object LongLines {

  //LongLines.processFile("/opt/tree.txt", 100)
  /*def processFile(fileName: String, width: Int): Unit = {
    val source = Source.fromFile(fileName)
    for (line <- source.getLines())
      processLine(fileName, width, line)
  }

  private def processLine(fileName: String, width:Int, line:String): Unit = {
    if (line.length > width) {
      println(fileName + ":" + line.trim)
    }
  }*/

  def processFile(fileName: String, width: Int): Unit = {
    val source = Source.fromFile(fileName)
    for (line <- source.getLines())
      processLine(line)

    def processLine(line: String): Unit = {
      //局部函数
      if (line.length > width) {
        println(fileName + ":" + line.trim)
      }
    }
  }


  (x: Int) => x + 1

  var increase = (x: Int) => x + 1

  var printAndIncrease = (x: Int) => {
    println(x + " + 1")
    x + 1
  }

  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  numbers.foreach(println)
  numbers.filter(x => x >= 5)
  numbers.filter(_ > 0)

  val add = (_: Int) + (_: Int)

  val addOne = add(_: Int, 1)

  //闭包
  var more = 100

  val addMore = (x: Int) => x + more // => 只能用变量，不可用  _  代替

  def addSome(some: Int): Int => Int = (x: Int) => some + x

  val add99 = addSome(99)
  val add999 = addSome(999)

  add99(1)
  add999(1)

  def echo(args: Int *): Unit = {
    args.foreach(println _)
  }

  echo(1, 2, 3)
  echo(Array(1, 2, 3): _*)

  def printTime(out:java.io.PrintStream = Console.out, unit: Int = 60): Unit = {
    println("time: " + System.currentTimeMillis() / unit)
  }

  printTime()
  printTime(unit = 3600)
}

