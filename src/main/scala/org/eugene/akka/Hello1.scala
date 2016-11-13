package org.eugene.akka

import akka.actor._

/**
 *
 * @author Eugene Wang
 * @since 15/8/10
 */
object Hello1 extends App {
  val system = ActorSystem("actor-demo-scala")
  val hello = system.actorOf(Props[Hello])
  hello ! "Bob"
  Thread sleep 1000
  system shutdown

  class Hello extends Actor {
    def receive = {
      case name: String => println(s"Hello $name")
    }
  }
}
