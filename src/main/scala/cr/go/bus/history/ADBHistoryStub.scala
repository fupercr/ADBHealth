/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.history

import cr.go.bus.entities.{ADBDatum, ADBJsonable}
import io.circe.Json

/**
  * The history log that later will be pushed into CouchDB
  *
  * It assumes that the key is obtained from hashing the string version of the
  * response and
  */
case class ADBHistoryStub(origin: String, level: String, service: String, action: String,
                          cached: Boolean, timestamp: Long, aDBHistoryStub: ADBHistoryStub) {

}
