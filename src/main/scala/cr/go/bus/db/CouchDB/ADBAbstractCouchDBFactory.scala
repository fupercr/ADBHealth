/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.db.CouchDB

import com.ibm.couchdb._
import cr.go.bus.db.ADBAbstractDBFactory

/**
  * The abstract class for databases allows defining new required active objects
  * that connect to CouchDB. This is convenient to enforce future implementations
  * of additional elements of the data space that agents may require to store,
  * for instance, information related to digital signatures or digital stamps.
  */
abstract class ADBAbstractCouchDBFactory extends ADBAbstractDBFactory {
  val couchServer: CouchDb
  val couchDb: CouchDbApi

  /**
    * Obtain the connection that has been established
    */
  def dbGet(): CouchDbApi = couchDb

  /**
    * Finalize the database connection. This should be used only at the agent
    * closing routines.
    */
  def dbFinalize(): Unit = {
    couchServer.client.client.shutdownNow()
  }
}
