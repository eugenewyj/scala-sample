package org.eugene.company

import java.io.PrintWriter

import scala.collection.mutable
import scala.io.Source
import scala.sys.process._

/**
 *
 * @author Eugene Wang
 * @since 0.0.1
 */
object QssLadderTimeoutStatistics extends App {
  val pattern = """^(\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})[\s\S]+""".r
  val pattern1 = """[\s\S]+ (l-[\s\S]+)$""".r
  val results = new mutable.HashMap[String, Int]
  val sourceName = "/Users/eugene/Downloads/access.2015-04-10.log"
  val targetName = "/Users/eugene/Downloads/access-result-0410.txt"
  val source = Source.fromFile(sourceName)
  for (line <- source.getLines()) {
    line match {
      case pattern(ip) => {
        results(ip) = results.getOrElse(ip, 0) + 1
      }
      case _ =>
    }
  }
  source.close()
  val out = new PrintWriter(targetName)
  results.toSeq.sortBy(_._2).foreach(t => {
    "host " + t._1 ! ProcessLogger(info => {
      val hostname = info match {
        case pattern1(host) => host
        case _ => "未解析出host"
      }
      out.println(t._1 + "\t" + hostname + "\t" + t._2)
    })
    //    out.println(t._1 + "\t" + t._2)
  })
  out.close()
}
