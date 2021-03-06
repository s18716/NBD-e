import scala.annotation.tailrec

object Assignment_1 {
  val days = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
  val products = Map("fruits" -> 1000, "vegetables" -> 500)

  def main(args: Array[String]): Unit = {
    println("Task_1:")
    println(Task_1("a"))
    println(Task_1("b"))
    println(Task_1("c"))
    println("Task_2:")
    println(Task_2("a", days))
    println(Task_2("b", days))
    println("Task_3:")
    println(Task_3(days))
    println("Task_4:")
    println(Task_4("a"))
    println(Task_4("b"))
    println(Task_4("c"))
    println("Task_5:")
    println(Task_5)
    println("Task_6:")
    println(Task_6(1 :: 2 :: 3 :: Nil))
    println("Task_7")
    println(Task_7(-11 :: -2.4 :: 3.0 :: 20.3 :: Nil))
    println("Task_8")
    task8(Tuple3(1, 300.2, "abc"))
    println("Task9")
    println(Task_9(-1.3 :: 2.1 :: 0.0 :: 3.4 :: 0.0 :: Nil))
    println("Task10")
    task10("vegetables")
    task10("fruits")
    task10("apples")

  }

  def Task_1(t: String): String = {
    var s: String = ""
    if (t.equals("a"))
      for (day <- days)
        s += day + ", "
    else if (t.equals("b"))
      for (day <- days if day.toLowerCase.startsWith("s"))
        s += day + ", "
    else if (t.equals("c")) {
      var i: Int = 0
      while (i < 7) {
        s += days(i) + ", "
        i += 1
      }
    }
    return s.substring(0, s.length - 2)
  }

  def Task_2(t: String, l: List[String]): String = {
    if (t == "a") {
      if (l.tail.isEmpty)
        return l.head
      return l.head + ", " + Task_2("a", l.tail)
    }
    if (t == "b") {
      if (l.tail.isEmpty)
        return l.head
      return Task_2("a", l.tail) + ", " + l.head
    } else return ""
  }
  def Task_3(ll: List[String]): String = {
    @tailrec
    def Task_3(l: List[String],s:String): String = {
      if (l.tail.isEmpty)
        return s+l.head
      else   Task_3(l.tail,s+l.head + ", ")
    }
    Task_3(ll,"")
  }

  def Task_4(t: String): String = {
    var s: String = ""
    if (t.equals("a"))
      s = days.foldLeft("")(_ + _ + ", ")
    else if (t.equals("b"))
      s = days.foldRight("")(_ + ", " + _)
    else if (t.equals("c"))
      s = days.foldRight("") { (next, sum) => if (next.toLowerCase.startsWith("s")) next + ", " + sum else sum }
    return s.substring(0, s.length - 2)
  }

  def Task_5: Map[String, Double] = products.mapValues(_ * 0.9)

  def Task_6(l: List[Int]): List[Int] = l.map(_ + 1)

  def Task_7(l: List[Double]): List[Double] = l.filter(-5 < _).filter(_ < 12).map(_.abs)

  def Task_8(tuple: Tuple3[Int, Double, String]): Unit = println(tuple)

  def Task_9(l: List[Double]): List[Double] = {
    if (l.isEmpty) l
    else if (l.head == 0) Task_9(l.tail)
    else l.head :: Task_9(l.tail)
  }

  def Task_10(product: String) = {
    val price: Option[Int] = products.get(product.toLowerCase)
    println(price.getOrElse("We don't have such items  -> " + product))
    if (price.isDefined && price.get >= 1000)
      println(product + " Put it in your bag and pay for it")
    println("#################################")
  }

}