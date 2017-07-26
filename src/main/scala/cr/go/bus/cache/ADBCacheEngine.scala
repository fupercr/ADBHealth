/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.cache

import com.ibm.couchdb.CouchDbApi
import cr.go.bus.db.CouchDB.ADBAbstractCouchDBEngine
import cr.go.bus.history.ADBCacheConnectionFactory
import org.slf4j.LoggerFactory

/**
  * This class takes care of handling all exchanges with the cache
  */
class ADBCacheEngine(couchDb: CouchDbApi) extends
  ADBAbstractCouchDBEngine(couchDb, ADBCacheConnectionFactory.mapper) {
  private val logger = LoggerFactory.getLogger(this.getClass)
  /**
    * Register a new payload and replace any existing one
    */
  def update(payload: ADBCacheMemoryStub): Unit = {
    //todo.implement
  }
}
