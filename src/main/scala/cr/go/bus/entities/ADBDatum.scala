/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.entities

import io.circe.Json
import com.roundeights.hasher.Implicits._
import java.time.Instant
import scala.collection.mutable.ArrayBuffer

/**
  * A datum is an entity that stores information coming in JSON format, to
  * be later transformed into text and back to JSON.
  */
abstract class ADBDatum(origin: String, routing: ArrayBuffer[String],service: String,
                        standard: String, stdVersion: String, payload: Json)
                        extends ADBHashable with ADBJsonable {
  var shaValue: String = getSHA512
  val timestamp: Long = Instant.now.toEpochMilli

  /**
    * Implement hash function
    */
  override def getSHA512 = (origin + service + payload.toString()).sha512

  /**
    * Implement JSON conversion function
    */
  override def toJson() : Json = this.toJson()

  /**
    * Add one level name at the end to construct the routing table. No full routes
    * are stored at any step to ensure adaptability in the long term.
    */
  def addHop(hop: String): Unit = {
    routing.append(hop)
  }
}
