/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.pki

import cr.go.bus.config.ADBConfigurable
import io.circe.Json

/**
  * A PKI encoder is a trait that uses asymmetric public key algorithms to
  * ensure secrecy. Some services may natively be
  */
trait ADBPkiEncoder extends ADBConfigurable {
  /**
    * Encode content of a term using a string that contains a public key
    */
  private def encodeValue(value: String): String = {
    ""
  }

  /**
    * Encode and pack a JSON file
    */
  def encodeJson(payload: Json): Json = {
    //todo.implement
    payload
  }
}
