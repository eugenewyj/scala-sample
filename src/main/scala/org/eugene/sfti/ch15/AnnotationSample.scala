package org.eugene.sfti.ch15

import scala.annotation.{switch, tailrec}
import scala.util.control.TailCalls
import scala.util.control.TailCalls.TailRec

/**
  * 注解样例类。
  *
  * @author Eugene Wang
  * @since 2016/11/24
  */
class AnnotationSample {

  //尾递归注解示例。
  @tailrec final def sumTotal(xs: Seq[Int], partial: BigInt): BigInt = {
    if (xs.isEmpty) partial else sumTotal(xs.tail, xs.head + partial);
  }

  //"蹦床"实现示例。
  final def evenLenght(xs: Seq[Int]): TailRec[Boolean] = {
    if (xs.isEmpty) TailCalls.done(true) else TailCalls.tailcall(oddLength(xs.tail))
  }
  final def oddLength(xs: Seq[Int]): TailRec[Boolean] = {
    if (xs.isEmpty) TailCalls.done(true) else TailCalls.tailcall(evenLenght(xs.tail))
  }

  //跳转表生成示例
  final def jumpTable(n: Int): String = {
    (n: @switch) match {
      case 0 => "Zero"
      case 1 => "One"
      case _ => "?"
    }
  }

  // 基本类型特殊化
  final def allDifferent[@specialized(Long, Double) T](x: T, y: T, z: T) = x != y && x != z && y != z

  // 错误及警告注解
  @deprecated(message = "此方法废弃") final def deprecated: Unit = {
    println("此方法已经废弃")
  }
  final def draw(@deprecatedName('sz) size: Int): Unit = {
    println("draw size = " + size)
  }
  final def matchInt(n: List[Int]): Int = {
    (n: @unchecked) match {
      case head :: _ => head
    }
  }
}
