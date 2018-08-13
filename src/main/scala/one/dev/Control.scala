package one.dev

/**
  * @Description:
  * @Date 下午3:50 2018/8/9
  * @Author: joker
  */
class Control {

  def testWhile(): Unit = {
    while (() != "") { //unit != string always return true!!!
      println("doing...")
    }
  }

  def testFor(): Unit = {
    val filesHere: Array[java.io.File] = (new java.io.File(".")).listFiles()
    for (file <- filesHere) {
      //file <- filesHere 生成器
      println(file)
    }

    for (i <- 1 to 10) {
      //Range.Inclusive
      println(i)
    }
  }

  def testForFilter(): Unit = {
    val filesHere = (new java.io.File(".")).listFiles()
    for (file <- filesHere
         if file.isFile
         if file.getName.endsWith(".scala")

    ) {
      //file <- filesHere 生成器
      println(file)
    }
  }

  val filesLocal = (new java.io.File(".")).listFiles()

  def fileLines(file: java.io.File): List[String] = {
    scala.io.Source.fromFile(file).getLines().toList
  }

  //multiFor(".*gcd.*")
  def multiFor(pattern: String): Unit = {
    for (
      file <- filesLocal if file.getName.endsWith(".scala"); //in (), use "," to split two for loops
      line <- fileLines(file) if line.trim.matches(pattern)
    ) println(file + ":" + line.trim)
  }

  //multiFor2(".*gcd.*")
  def multiFor2(pattern: String): Unit = {
    for {
      file <- filesLocal if file.getName.endsWith(".scala") //in {}, don't use "," to split two for loops
      line <- fileLines(file) if line.trim.matches(pattern)
    } println(file + ":" + line.trim)
  }

  def multiFor3(pattern: String): Unit = {
    for {
      file <- filesLocal if file.getName.endsWith(".scala") //in {}, don't use "," to split two for loops
      line <- fileLines(file) if line.trim.matches(pattern)
    } println(file + ":" + line.trim)
  }

  def multiFor4(pattern: String): Unit = {
    for {
      file <- filesLocal if file.getName.endsWith(".scala") //in {}, don't use "," to split two for loops
      line <- fileLines(file)
      trimed = line.trim  //in {}, define a variable do not need "val"
      if trimed.matches(pattern)
    } println(file + ":" + trimed)
  }

  def testMatch(): String = {
    val arg = "vip"
    arg match {
      case "passport" => println("passport");"passport"
      case "spark" => print("spark");"spark"
      case _ => println("spark ml");"spark ml"
    }
  }

  def noBreakContinueByWhile(): Unit = {
    var i = 0
    var break = false
    while (i < filesLocal.length && !break) {
      if (filesLocal(i).getName.startsWith("Con")) {
        if (filesLocal(i).getName.endsWith(".scala")) {
          println(filesLocal(i))
          break = true
        }
      }
      i += 1
    }
  }

  def noBreakContinueByRec(index: Int): String = {
    if (index >= filesLocal.length - 1) "not found"
    else if (!filesLocal(index).getName.startsWith("Con")) noBreakContinueByRec(index + 1)
    else if (filesLocal(index).getName.endsWith(".scala")) filesLocal(index).getName
    else noBreakContinueByRec(index + 1)
  }

}
