/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.json

import cr.go.bus.entities.ADBPayload
import io.circe.Json

/**
  * This object takes care of the conversion between various dynamic objects and
  * JSON.
  */
object ADBJsonObjectConverter {
  /**
    * Convert Payload to JSON
    */
  def payloadToJSON(payload: ADBPayload): Json = {
    //todo.implement
    Json.Null
  }

  /**
    * Convert JSON to Payload
    */
  def JSONToPayload(json: Json): ADBPayload= {
    //todo.implement
    new ADBPayload
  }
}
