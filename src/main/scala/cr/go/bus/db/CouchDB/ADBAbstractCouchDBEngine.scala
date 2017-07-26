/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/

package cr.go.bus.db.CouchDB

import com.ibm.couchdb.{CouchDbApi, TypeMapping}
import cr.go.bus.db.ADBAbstractDBEngine

/**
  * The DB manager is an abstraction that controls DB operations. This class must
  * be implemented based on an access given by a CouchDbApi
  */
abstract class ADBAbstractCouchDBEngine(val couchDb: CouchDbApi,
                                        mapping: TypeMapping)
                                      extends ADBAbstractDBEngine {
  /**
    * Is the database functional?
    */
  def isFunctional: Boolean = {
    if (! couchDb.name.isEmpty)
      true
    else
      false
  }
}
