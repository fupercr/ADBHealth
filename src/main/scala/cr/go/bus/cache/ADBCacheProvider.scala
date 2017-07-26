/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.cache

import cr.go.bus.history.ADBCacheConnectionFactory

/**
  * The cache provider trait allows objects to have access to their cache
  * memory. It is expected that
  */
trait ADBCacheProvider {
  val engine: ADBCacheEngine = new ADBCacheEngine(ADBCacheConnectionFactory.dbGet())

  /**
    * Update the cache with a given response
    */
  def updateResponse(cacheStub: ADBCacheMemoryStub): Unit = {
    engine.update(cacheStub)
  }
}
