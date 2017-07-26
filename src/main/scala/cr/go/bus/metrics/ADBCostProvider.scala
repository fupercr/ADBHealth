/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.metrics

/**
  * This trait provides a concrete means for an agent to compute the cost of
  * every hop based on the call. We add and propagate costs when computing
  * upwards. The latter reflects how
  */
trait ADBCostProvider {
  /**
    * Start the chronometer for this agent
    */
  def chronoStart(): Unit = {
    ADBCostFactory.chronoStart()
  }

  /**
    * Start the chronometer for this agent
    */
  def chronoEnd(): Unit = {
    ADBCostFactory.chronoEnd()
  }

  /**
    * Obtain the simple current operational cost for an agent
    *
    * This requires having guarded the start and end
    * of the process with respective chronometer calls.
    */
  def getSimpleCost(): ADBCostStub = {
    ADBCostFactory.computeBasicCost()
  }

  /**
    * Obtain the compound current operational cost for an agent. This
    * method uses data from the cache in routing operations.
    *
    * This requires having guarded the start and end
    * of the process with respective chronometer calls as well.
    */
  def getAccumulatedCost(cost: ADBCostStub): ADBCostStub = {
    ADBCostFactory.computeAccumulatedCost(cost)
  }
}
