/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.routing

import cr.go.bus.entities.ADBQuery

import scala.collection.mutable.HashMap

/**
  * A forward router trait takes care of finding the next hop to deliver data.
  * The table is constructed by (service, nextHop) pairs.
  *
  */
trait ADBForwardRouter {
  /**
    * The routing table takes services and outputs a next hop
    */
  var routingTable: HashMap[String, String] = HashMap()

  /**
    * Register next hop
    */
  def registerHop(service: String, nextHop: String): Unit = {

  }

  /**
    * Forward a query to the next level, this remains abstract depending on the
    * agent type. Miners do not forward. Our setting removes the temptation of
    * future developers to rely on forward as a direct update mechanism.
    */
  def forward(aDBQuery: ADBQuery): Unit

  /**
    * Receive a response from below. If the target service of the response has
    * not been exhausted,
    */
}
