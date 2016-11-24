package org.eugene.sfti.ch15

import scala.annotation.varargs

/**
  * 练习题用到的类
 *
  * @author Eugene Wang
  * @since 2016/11/24
  */
class AnnotationExercise {
  @varargs def sum(a: Int*): Int = {
    a.foldLeft(0)(_ + _)
  }
}
