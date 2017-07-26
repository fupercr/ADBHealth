/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.entities

/**
  * Payload types provide special treatment for generic dynamic objects. In
  * this case, we do not implement additional method calls (e.g. sums, concats)
  * and prefer to rely on the internal data types that are registered.
  */

object ADBPayloadTypes {
  sealed abstract class ADBPayloadType[A] {
    def exec(as: A*): A
  }
}