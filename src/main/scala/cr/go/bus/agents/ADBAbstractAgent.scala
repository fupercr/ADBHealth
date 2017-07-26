/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.agents

import akka.actor.Actor
import cr.go.bus.config.ADBConfigurable
import cr.go.bus.http.ADBHttpServe
import cr.go.bus.routing.ADBRouteLevelType

/**
  * An abstract agent contains all the necessary elements for building more
  * specific routing agents.
  */
abstract class ADBAbstractAgent extends Actor with ADBHttpServe with
                                                            ADBConfigurable {
  /**
    * Internal variables of a standard agent. We decouple routing and reverse
    * routing as traits.
    */
  val name = this.agentName
  val host = this.agentHost
  val port = this.agentPort

  /**
    * Define the execution context
    */
  implicit def actorRefFactory = context

  /**
    * Compute the level number of the agent from a parameter
    */
  protected def getLevelNumber(typ: ADBRouteLevelType.Value): Int = {
    typ match {
      case ADBRouteLevelType.Master   => 100
      case ADBRouteLevelType.Api      => 99
      case ADBRouteLevelType.Root     => 0
      case ADBRouteLevelType.Sector   => 1
      case ADBRouteLevelType.Agency   => 2
      case ADBRouteLevelType.Service  => 3
      case ADBRouteLevelType.Miner    => 4
      case _                          => -1000
    }
  }

  /**
    * Initialize agent
    */
  def init(): Unit

  /**
    * Start agent
    */
  def start(): Unit

  /**
    * Stop agent
    */
  def stop(): Unit

  /**
    * Finalize agent
    */
  def end(): Unit

  /**
    * Define the receiving end
    */
  def receive = runRoute(rest)

}
