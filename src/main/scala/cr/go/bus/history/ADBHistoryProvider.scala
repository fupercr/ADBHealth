/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.history

/**
  * The cache provider trait allows objects to have access to their cache
  * memory. It is expected that
  */
trait ADBHistoryProvider{
  val engine: ADBHistoryEngine = new ADBHistoryEngine(ADBHistoryConnectionFactory.dbGet())

  /**
    * Update the cache with a given response
    */
  def updateResponse(historyStub: ADBHistoryStub): Unit = {
    engine.insert(historyStub)
  }
}
