/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.agents

import cr.go.bus.history.ADBHistoryProvider
import cr.go.bus.metrics.ADBCostProvider
import cr.go.bus.pki.ADBPkiProvider
import cr.go.bus.routing.ADBBackwardsRouter
import cr.go.bus.sources.ADBDataSource
import cr.go.bus.translation.ADBTranslator

/**
  * A miner agent is an abstract representation for agents that interact with
  * systems directly and produce Json objects. They do not route forward, only
  * backwards. Miners translate terms into official standards.
  *
  * Miner agents need to be implemented by
  */
abstract class ADBMinerAgent extends ADBAbstractAgent with ADBDataSource with ADBHistoryProvider
                              with ADBBackwardsRouter with ADBTranslator with ADBCostProvider {
}
