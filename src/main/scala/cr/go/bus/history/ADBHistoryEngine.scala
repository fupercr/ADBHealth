/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.history

import com.ibm.couchdb._
import cr.go.bus.db.CouchDB.ADBAbstractCouchDBEngine

/**
  * The history engine takes care of pushing logging data into a distributed historic
  * database. It may be defined at any level, but this justifies a datacenter-distributed
  * implementation.
  */
class ADBHistoryEngine(couchDb: CouchDbApi) extends
  ADBAbstractCouchDBEngine(couchDb: CouchDbApi, ADBHistoryConnectionFactory.mapper) {
  /**
    * Insert a new payload concurrently. We assume a possibly concurrent
    * and distributed history database.
    */
  def insert(payload: ADBHistoryStub): Unit = {
    //todo.implement
  }
}
