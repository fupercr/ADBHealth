/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.pki

import scala.collection.mutable.HashMap


/**
  * The PKI provider is a trait that takes care of encrypting content (queries
  * or responses) to send them in a secure way. Only PKI, API and Miner agents
  * can be
  */
trait ADBPkiProvider {
  /**
    * Stored public keys.
    */
  var pkiTable: HashMap[String, String] = new HashMap[String,String]()

  /**
    * Obtain public key from host and port
    */

  def getPublicKey(host: String, port: String): String = {
    pkiTable.get(host+port).toString
  }

  /**
    * Register a new service
    */
  def register(host: String, port: String, pkey: String): Unit = {
    pkiTable.put(host+port, pkey)
  }
}
