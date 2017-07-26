/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.entities

import io.circe.Json
import scala.collection.mutable.ArrayBuffer

/**
  * Queries take a Json object as the payload and builds a context around in
  * the spirit of a packet.
  *
  * Sequence information indicates that the query is not resolved until the array
  * is empty. Usually there is only one destination equal to the origin. If
  * that is not the case, it represents a complex tramit.
  *
  * The type of standard is recorded.
  **/
case class ADBQuery(origin: String, routing: ArrayBuffer[String], sequence: ArrayBuffer[String],
               service: String, standard: String, stdVersion: String, qry: Json,
               pubkey: String)
                extends ADBDatum(origin, routing, service, standard, stdVersion, qry) {
  /**
    * If the public key is not specified, it will not be included in the final
    * query.
    */
  def this(origin: String, routing: ArrayBuffer[String], sequence: ArrayBuffer[String],
           service: String, standard: String, stdVersion: String, qry: Json) =
    this(origin, routing, sequence, service, standard, stdVersion, qry, "")

  /**
    * We may have a case where the origin and the destination is the same
    **/
  def this(origin: String, routing: ArrayBuffer[String], service: String, standard: String,
           stdVersion: String, obj: Json, pubkey: String) =
    this(origin, routing, ArrayBuffer(origin), service, standard, stdVersion, obj, pubkey)
}