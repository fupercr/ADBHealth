/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.history

import cr.go.bus.config.ADBConfigurable
import com.ibm.couchdb._
import cr.go.bus.db.CouchDB.ADBAbstractCouchDBFactory

/**
  * The history connection factory is an object that takes
  * care of initializing CouchDB access for a single agent.
  * We use a singleton pattern to enforce the one agent-
  * one connection restriction.
  */
object ADBHistoryConnectionFactory extends ADBAbstractCouchDBFactory
                                  with ADBConfigurable {

  val dbMapping = TypeMapping(classOf[ADBHistoryStub] -> "HistoryLog")
  val dbHost = this.historyHost
  val dbPort = this.historyPort
  val dbUser = this.historyUser
  val dbPswd = this.historyPswd
  val dbName = this.historyName
  val dbHttps = this.historyHttps

  /**
    * Initialization of the database
    */
  val couchServer: CouchDb = CouchDb(dbHost, dbPort, false, dbUser, dbPswd)
  val couchDb: CouchDbApi = couchServer.db(dbName, dbMapping)

  /**
    * Obtain the mapper for this object
    */
  def mapper: TypeMapping = dbMapping
}
