/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.sources

import io.circe.Json

/**
  * We model a source, an entity capable of reading directly from a system and
  * obtaining a Json value. This is an abstract class since implementation details.
  * In general, these are the tools for building mining agents at the server side.
  *
  * Payloads are created here for the first time.
  */
trait ADBDataSource {
  /**
    * Obtain a JSON representation of the datum. This is application dependent.
    */
  def get: Json
}