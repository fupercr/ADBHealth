/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.agents

import cr.go.bus.entities.ADBQuery
import cr.go.bus.history.ADBHistoryProvider
import cr.go.bus.metrics.ADBCostProvider
import cr.go.bus.pki.ADBPkiProvider
import cr.go.bus.routing.ADBForwardRouter
import cr.go.bus.sources.ADBDataSource
import cr.go.bus.translation.ADBTranslator
import io.circe.Json
import spray.http.HttpHeaders.RawHeader
import spray.routing.{Directive0, Route}

import scala.xml.NodeSeq

/**
  * The API agent is the topmost agent in the system, installed at
  */
class ADBPkiApiAgent extends ADBAbstractAgent with ADBDataSource with ADBHistoryProvider
                        with ADBForwardRouter with ADBTranslator with ADBCostProvider
                        with ADBPkiProvider {
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
    * Forward a query to the next level, this remains abstract depending on the
    * agent type. Miners do not forward. Our setting removes the temptation of
    * future developers to rely on forward as a direct update mechanism.
    */
  override def forward(aDBQuery: ADBQuery): Unit = {
    //todo.implement
  }

  /**
    * Load from XML.
    *
    * This must be implemented by topmost concrete standards
    */
  override def loadTableXML(file: NodeSeq): Unit = {
    //todo.implement
  }

  /**
    * Load from JSON.
    *
    * This must be implemented by topmost concrete standards
    */
  override def loadTableJson(file: Json): Unit = {
    //todo.implement
  }

  /**
    * Load from CVS.
    *
    * This must be implemented by topmost concrete standards
    */
  override def loadTableCVS(file: String): Unit = {
    //todo.implement
  }

  /**
    * We leave the rest implementation value to the concrete entities.
    */
  override val rest: Directive0 = {
    respondWithSingletonHeader(RawHeader("Api agent", "host: %s, port: %s".format(agentHost, agentPort)))
    //todo.implement: particular calls
  }
}
