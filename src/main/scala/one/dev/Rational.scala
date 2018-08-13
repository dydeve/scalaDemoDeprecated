package one.dev

/**
  * @Description:
  * @Date 下午2:26 2018/8/9
  * @Author: joker
  */
class Rational(n: Int, d: Int) {
  //println("main constructor" + n + "/" + d)//主构造函数
  require(d != 0)

  def this(n: Int) = this(n ,1)

  private val gcd: Int = gcd(n.abs, d.abs)

  val number = n / gcd
  val denom = d /gcd

  //res15: Rational = Rational@784bea2c
  //res16: Rational = 1/2
  override def toString: String = number + "/" + denom

  def add(that: Rational) = new Rational(
    number * that.denom + denom * that.number,
    denom * that.denom)

  def lessThan(that: Rational) = number * that.denom < denom * that.number

  def max(that: Rational): Rational =
    if (lessThan(that))
      that
    else
      this

  //def + (i: Int): Rational = new Rational(number + i * denom, denom)

  def +(other: Rational): Rational = add(other)

  private def gcd(x:Int, y:Int): Int = {
    if (y == 0)
      x
    else
      gcd(y, x % y)
  }

  def gcdLoop(x:Int, y:Int): Int = {
    var a= x
    var b = y
    while (a != 0) {
      val tmp = a
      a = b % a
      b = tmp
    }

    b
  }

}

object Rational {

  implicit def intToRational(x: Int) = new Rational(x)

  def main(args: Array[String]): Unit = {
    val oneHalf = new Rational(1, 2)
    val twoThird = new Rational(2, 3)
    val total = oneHalf add twoThird


    val gcd = Rational(20, 10)

    //2 + gcd
  }

  def apply(n: Int, d: Int): Rational = new Rational(n, d)
}
