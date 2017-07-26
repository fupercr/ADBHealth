/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.runtime

import akka.actor.{ActorSystem,Props}
import akka.io.IO
import cr.go.bus.agents.{ADBAbstractAgent, ADBAgentFactory}
import cr.go.bus.config.ADBConfigurable
import spray.can.Http

/**
  * Top level object that executes an agent in a server. This is bound to change
  * in the future by injecting a population of agents, not only one.
  */
object ADBAgentDriver extends App with ADBConfigurable {
  /**
    * Declare the agent system
    */
  implicit val system = ActorSystem("Agent-Distributed-Bus-Costa-Rica")

  /**
    * Obtain the agent based on its configuration
    */
  val agent:ADBAbstractAgent = ADBAgentFactory.get()

  /**
    * Create the new agent in the container
    */
  val restService = system.actorOf(Props[ADBAbstractAgent], "rest-endpoint")

  /**
    * Start the respective HTTP agent
    */
  IO(Http) ! Http.Bind(restService, agentHost, agentPort)
}