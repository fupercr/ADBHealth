/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.cache

import cr.go.bus.entities.ADBPayload
import cr.go.bus.json.ADBJsonObjectConverter
import cr.go.bus.metrics.ADBCostStub
import io.circe.Json

/**
  * This case class is used to store a stub from memory to the database thanks to
  * the variable payload object.
  */
case class ADBCacheDBStub (key: String, response: ADBPayload, ttl: Long,
                           timestamp:Long, cost: ADBCostStub) {
  /**
    * Convert to memory stub
    */
  def toMemoryStub: Unit= {
    new ADBCacheMemoryStub(key, ADBJsonObjectConverter.payloadToJSON(response), ttl,
                                                                    timestamp, cost)
  }
}
