/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.routing

import cr.go.bus.entities.{ADBQuery, ADBResponse}
import scala.collection.mutable.HashMap

/**
  * Reverse routing takes care of interactions with the upper level, including
  * sending data that has been computed.
  */
trait ADBBackwardsRouter {
  var reverseRoutingTable: HashMap[String, String] = HashMap()
  /**
    * The reverse routing table temporarily stores sha values of queries
    * and deletes them when
    */
  /**
    * Ping the server upwards
    */
  def pingReverse: Long = {
    //todo.implement
    0
  }

  /** Queries are registered for posterior resolution with their parents
    */
  def registerQuery(query: ADBQuery, parent: String): Unit = {
    reverseRoutingTable.put(query.shaValue, parent)
    //todo.implement
  }

  /**
    * Reverse forward
    *
    * This operation takes care of adding extra costs. When a response reaches
    * the upper level, the query is deleted from the local routing table.
    */
  def reverseForward(response: ADBResponse): Unit = {
    //todo.implement
    reverseRoutingTable.remove(response.shaValue)
  }
}

