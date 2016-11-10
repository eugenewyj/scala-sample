package com.fengbaoxp.scala.hello

/**
 * HelloScala样例。
 * @author Eugene Wang
 * @since 15/7/18
 */
object HelloScala {
  def main(args: Array[String]): Unit = {
    println("Hello Scala!")
    for (arg <- args) {
      println(">>>", arg)
    }
  }
}
