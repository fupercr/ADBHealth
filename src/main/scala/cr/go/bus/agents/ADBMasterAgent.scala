/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.agents

import cr.go.bus.history.ADBHistoryProvider
import cr.go.bus.master.ADBMaster
import spray.http.HttpHeaders.RawHeader
import spray.routing.Route

class ADBMasterAgent extends ADBAbstractAgent with ADBMaster with ADBHistoryProvider {
  /**
    * Initialize agent
    */
  override def init(): Unit = {

  }

  /**
    * Start agent
    */
  override def start(): Unit = {

  }

  /**
    * Stop agent
    */
  override def stop(): Unit = {

  }

  /**
    * Finalize agent
    */
  override def end(): Unit = {

  }

  /**
    * We leave the rest implementation value to the concrete entities.
    */
  override val rest = {
    respondWithSingletonHeader(RawHeader("Master agent", "host: %s, port: %s".format(agentHost, agentPort)))
    //todo.implement: particular calls
  }
}
