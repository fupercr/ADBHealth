/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.agents

import cr.go.bus.cache.ADBCacheProvider
import cr.go.bus.entities.ADBQuery
import cr.go.bus.history.ADBHistoryProvider
import cr.go.bus.routing.{ADBBackwardsRouter, ADBForwardRouter}
import spray.http.HttpHeaders.RawHeader
import spray.routing.Directive0

/**
  * A sectorial processing agent
  */
class ADBSectorAgent extends ADBAbstractAgent with ADBForwardRouter with ADBBackwardsRouter
  with ADBCacheProvider with ADBHistoryProvider with ADBRegistrable {
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
    * Forward a query to the next level.
    */
  override def forward(aDBQuery: ADBQuery): Unit = {

  }

  /**
    * We leave the rest implementation value to the concrete entities.
    */
  override val rest: Directive0 = {
    respondWithSingletonHeader(RawHeader("Sector agent", "host: %s, port: %s".format(agentHost, agentPort)))
    //todo.implement: particular calls
  }

  override var parent: String = _
}