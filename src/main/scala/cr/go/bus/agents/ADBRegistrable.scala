/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.agents

import cr.go.bus.routing.ADBBackwardsRouter
import cr.go.bus.service.ADBService

/**
  * An agent is registrable with its parent if it is not an API, Master or Root
  * agent. Registering is performed upwards by a special message interface.
  */
trait ADBRegistrable extends ADBBackwardsRouter {
  var parent: String

  /**
    * Register a service at the parent.
    */
  def registerUpstream(service: ADBService): Unit = {
    //todo.implement
  }
}
