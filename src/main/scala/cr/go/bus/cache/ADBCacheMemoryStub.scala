/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/

package cr.go.bus.cache

import cr.go.bus.entities.{ADBJsonable, ADBPayload}
import cr.go.bus.json.ADBJsonObjectConverter
import cr.go.bus.metrics.ADBCostStub
import io.circe.Json

/**
  * This class tales care of creating the JSON object for a cache stub. The cache
  * contains a specification of a ttl
  */
case class ADBCacheMemoryStub(key: String, response: Json, ttl: Long, timestamp:Long,
                              cost: ADBCostStub) extends ADBJsonable{
  /**
    * Check validity against current time in millis.
    */
  def isValid(current: Long) : Boolean = {
    if ( (current - timestamp)/1000 >= ttl)
      true
    else
      false
  }

  /**
    * Get JSON representation
    */
  override def toJson() : Json = this.toJson()

  /**
    * Get a representative memory stub
    */
  def toDBStub: Unit = {
    new ADBCacheDBStub(key, ADBJsonObjectConverter.JSONToPayload(response), ttl, timestamp, cost)
  }
}
