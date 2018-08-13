package one
package dev

import scala.collection.mutable.Map//默认是immutable，手动引入

/**
  * @Description:
  * @Date 上午10:00 2018/8/13
  * @Author: joker
  */
class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte): Unit = sum += b

  def checksum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = Map[String, Int]()

  def calculate(s: String): Int = {
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
  }

  //ChecksumAccumulator.calculate("Welcome to Scala Chinese community")

}
