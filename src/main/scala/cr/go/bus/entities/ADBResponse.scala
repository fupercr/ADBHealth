/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.entities

import cr.go.bus.metrics.ADBCostStub
import io.circe.Json
import scala.collection.mutable.ArrayBuffer

/**
  * A response is an object that can directly be sent back to the source
  * We preserve the SHA-512 of the query.
  **/
case class ADBResponse(key: String, origin: String, routing: ArrayBuffer[String],
                       sequence: ArrayBuffer[String], service: String, standard: String,
                       stdVersion: String, rsp: Json, cost: ADBCostStub,
                       ttl: Double) extends
          ADBDatum(origin, routing, service, standard, stdVersion, rsp) {
  /**
    * Do not use Json's SHA-512, use the query's
    */
  this.shaValue = key

  /**
    * Sequence information for origin case. Sequences are ordered as a stack.
    */
  def this(key: String, origin: String, routing: ArrayBuffer[String], service: String,
           standard: String, stdVersion: String, rsp: Json, cost: ADBCostStub, ttl: Double) =
    this(key: String, origin, routing, ArrayBuffer(origin), service, standard, stdVersion, rsp, cost, ttl)

  /**
    * Convert this response into a new query. This is used when the sequence value
    * at the bottom of the stack is not empty and it must be redirected downwards
    * after a query has made it into the previous service.
    *
    * The SHA-512 key is generated as a new query, since the same step in a complex
    * tramit may arise multiple times. The more steps, the least probable it will
    * be reused at the final ones. The CouchDB cache will however store it and remove
    * it until its TTL, which is determined by the service configuration.
    */
  def toQuery(): Unit = {
    //todo.implement ADBQuery
  }

  /**
    * Remove a sequence level from the bottom.
    */
  def popSequence: Boolean = {
    //todo.implement
    false
  }
}
