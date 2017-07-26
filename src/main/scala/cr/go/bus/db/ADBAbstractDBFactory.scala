/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.db

import com.ibm.couchdb.TypeMapping

/**
  * This class represents the most basic elements to be implemented by a database
  * object.
  */
abstract class ADBAbstractDBFactory {
  val dbMapping: TypeMapping
  val dbHost: String
  val dbPort: Int
  val dbUser: String
  val dbPswd: String
  val dbName: String
  val dbHttps: Boolean

  /**
    * Obtain a connection to the database
    */
  def dbGet

  /**
    * Finalize access to the database
    */
  def dbFinalize: Unit
}
