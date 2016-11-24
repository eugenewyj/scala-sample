/**
  * 注解相关示例类调用脚本
  * @author Eugene Wang
  * @since 2016/11/24
  */

import org.eugene.sfti.ch15.AnnotationSample

val sample = new AnnotationSample
println("尾递归注释调用：" + sample.sumTotal(1 to 100, 0))

println("TailCalls调用示例1：" + sample.oddLength(1 to 100).result)
println("TailCalls调用示例2：" + sample.evenLenght(1 to 100).result)

println("跳表实现调用示例1：" + sample.jumpTable(0))
println("跳表实现调用示例2：" + sample.jumpTable(1))
println("跳表实现调用示例3：" + sample.jumpTable(2))

println("基本类型特殊化示例：" + sample.allDifferent(1, 2, 3))

sample.deprecated
sample.draw(size = 12)

sample.matchInt(List(1, 2, 3))