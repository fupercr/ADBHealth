/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.db.SQL

import cr.go.bus.db.ADBAbstractDBFactory

/**
  * An abstract SQL factory that is decoupled from
  */
abstract class ADBAbstractSQLDBFactory extends ADBAbstractDBFactory {
  val sqlServer: ADBAbstractSQLServer
  val sqlDb: ADBAbstractSQLDb

  /**
    * Obtain the connection that has been established
    */
  def dbGet: ADBAbstractSQLDb = sqlDb

  /**
    * Finalize the database connection. This should be used only at the agent
    * closing routines.
    */
  def dbFinalize: Unit = {
    sqlDb.close()
  }

}
