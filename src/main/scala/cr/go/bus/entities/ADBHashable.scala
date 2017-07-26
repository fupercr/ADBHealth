/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.entities

/**
  * We provide this trait for all hashable entities
  */
trait ADBHashable {
  def getSHA512: String
}
