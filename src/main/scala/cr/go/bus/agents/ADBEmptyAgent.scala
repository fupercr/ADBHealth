/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.agents
import spray.http.HttpHeaders.RawHeader
import spray.routing.Route

/**
  * Empty agents appear when the configuration finds an agent type that does not
  * correspond to existing agent types.
  */
class ADBEmptyAgent extends ADBAbstractAgent {
  /**
    * Initialize agent
    */
  override def init(): Unit = {}

  /**
    * Start agent
    */
  override def start(): Unit = {}

  /**
    * Stop agent
    */
  override def stop(): Unit = {}

  /**
    * Finalize agent
    */
  override def end(): Unit = {}

  /**
    * We leave the rest implementation value to the concrete entities.
    */
  val respondWithUnknownHeader =
    respondWithSingletonHeader(RawHeader("Unknown service", "host: %s, port: %s".format(agentHost, agentPort)))

  override val rest = path("foo") {
    respondWithStatus(201) {
      complete("beep")
    }
  }
}
