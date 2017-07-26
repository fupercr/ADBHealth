/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.entities

import io.circe.Json

/**
  * We provide a trait for all objects that need to be converted to JSON
  */
trait ADBJsonable {
  def toJson: Json
}