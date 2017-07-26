/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.db.SQL

/**
  * Implements an abstract SQL database, which is a container to be implemented
  * by actual JDBC connectors.
  */
abstract class ADBAbstractSQLDb {
  /**
    * Close the connection to the database
    */
  def close(): Unit
}
