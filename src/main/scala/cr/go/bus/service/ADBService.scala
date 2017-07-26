/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.service

import cr.go.bus.entities.ADBJsonable
import io.circe.Json

/**
  * The service class provides a representation for a service that
  * is pushed upwards for registration into its parent.
  */
case class ADBService(name: String, host: String) extends ADBJsonable {
  /**
    * Transform to Json
    */
  def toJson: Json = {
    this.toJson
  }
}
