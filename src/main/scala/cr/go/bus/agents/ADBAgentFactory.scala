/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.agents

import cr.go.bus.config.ADBConfigurable
import cr.go.bus.routing.ADBRouteLevelType

/**
  * An agent factory takes in a string and generates a particular class of
  * concrete agent. Use the configuration file to generate it.
  **/
object ADBAgentFactory extends ADBConfigurable {
  /**
    * For a given configuration, produce the appropriate concrete agent type.
    * Used at runtime.
    *
    * Cases are added here.
    */
  def get(): ADBAbstractAgent = {
    if (getLevelType(agentLevel) == ADBRouteLevelType.Master) {
      new ADBMasterAgent
    }
    else if (getLevelType(agentLevel) == ADBRouteLevelType.Api) {
      new ADBApiAgent
    }
    else if (getLevelType(agentLevel) == ADBRouteLevelType.PkiApi) {
      new ADBPkiApiAgent
    }
    else if (getLevelType(agentLevel) == ADBRouteLevelType.Root) {
      new ADBRootAgent
    }
    else if (getLevelType(agentLevel) == ADBRouteLevelType.Sector) {
      new ADBSectorAgent
    }
    else if (getLevelType(agentLevel) == ADBRouteLevelType.Agency) {
      new ADBAgencyAgent
    }
    else if (getLevelType(agentLevel) == ADBRouteLevelType.Service) {
      new ADBServiceAgent
    }
    /**
      * Area reserved for future mining agents
      */
    else {

      /** If no other agent type is found, create a dummy agent that outputs a
        * header
        */
      new ADBEmptyAgent()
    }
  }

  /**
    * Compute the level type of the agent from a parameter
    */
  protected def getLevelType(value: String): ADBRouteLevelType.Value = {
    value match {
      case "master"   => ADBRouteLevelType.Master
      case "api"      => ADBRouteLevelType.Api
      case "root"     => ADBRouteLevelType.Root
      case "sector"   => ADBRouteLevelType.Sector
      case "agency"   => ADBRouteLevelType.Agency
      case "service"  => ADBRouteLevelType.Service
      case "miner"    => ADBRouteLevelType.Miner
      case _          => ADBRouteLevelType.Unknown
    }
  }
}
