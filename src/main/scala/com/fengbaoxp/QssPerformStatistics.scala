package com.fengbaoxp

import java.io.PrintWriter

import _root_.scala.collection.mutable
import _root_.scala.io.Source

/**
 *
 * @author Eugene Wang
 * @since 0.0.1
 */
object QssPerformStatistics extends App {
  val pattern = """\$\$EnhancerByCGLIB\$\$[\s\S]+-/"""
  val pattern1 = """ApplyController-/apply/gotoapprove/\d+"""
  val pattern2 = """CustomerController-/customer/edit/\d+"""
  val results = new mutable.HashMap[String, Tuple5[String, Int, Int, Int, Int]]
  val sourceName = "/Users/eugene/Workspace/Qunar/项目文档/问题记录/QSS系统性能问题/性能数据20150505-20150506.txt"
  val targetName = "/Users/eugene/Workspace/Qunar/项目文档/问题记录/QSS系统性能问题/性能数据统计结果.txt"
  val source = Source.fromFile(sourceName)
  for (line <- source.getLines()) {
    val splited = line split "\t"
    val req = splited(0).replaceAll(pattern, """-/""").replaceAll(pattern1, """ApplyController-/apply/gotoapprove/""").replaceAll(pattern2, """CustomerController-/customer/edit/""")
    val current = results.getOrElse(req, (req, 0, 0, 10000000, 0))
    results(req) = (req, current._2 + Integer.valueOf(splited(1)), current._3 + Integer.valueOf(splited(2)), Math.min(current._4, Integer.valueOf(splited(4))), Math.max(current._5, Integer.valueOf(splited(5))))
  }
  source.close()
  val out = new PrintWriter(targetName)
  out.println("请求路径\t总请求次数\t总请求时间\t平均响应时间\t最小响应时间\t最常响应时间");
  results.toSeq.sortBy(_._2._2).foreach(t => {
    if (t._2._3 / t._2._2 > 2000) {
      out.println(t._2._1 + "\t" + t._2._2 + "\t" + t._2._3 + "\t" + (t._2._3 / t._2._2) + "\t" + t._2._4 + "\t" + t._2._5 + "\t")
    }
  })
  out.close()
}
