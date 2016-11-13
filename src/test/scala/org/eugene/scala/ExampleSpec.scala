package org.eugene.scala

import java.util

import org.scalatest.{FlatSpec, Matchers}

/**
 *
 * @author Eugene Wang
 * @since 15/8/27
 */
class ExampleSpec extends FlatSpec with Matchers {
  "堆栈" should "按照后入先出的顺序弹出" in {
    val stack = new util.Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }
}
