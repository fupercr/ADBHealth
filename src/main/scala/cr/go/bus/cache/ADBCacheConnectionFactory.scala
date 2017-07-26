/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.history

import cr.go.bus.config.ADBConfigurable
import com.ibm.couchdb._
import cr.go.bus.cache.ADBCacheDBStub
import cr.go.bus.db.CouchDB.ADBAbstractCouchDBFactory

/**
  * The history connection factory is an object that takes
  * care of initializing CouchDB access for a single agent.
  * We use a singleton pattern to enforce the one agent-
  * one connection restriction.
  */
object ADBCacheConnectionFactory extends ADBAbstractCouchDBFactory
  with ADBConfigurable {
  val dbMapping = TypeMapping(classOf[ADBCacheDBStub] -> "HistoryLog")
  val dbHost = this.cacheHost
  val dbPort = this.cachePort
  val dbUser = this.cacheUser
  val dbPswd = this.cachePswd
  val dbName = this.cacheName
  val dbHttps = this.cacheHttps

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