/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.db

import org.slf4j.LoggerFactory

/**
  * An abstract DB engine takes care of regularizing all types of databases and add
  * logging capabilities. Logging happens at the server level, not at the global
  * historic level.
  */
class ADBAbstractDBEngine {
  private val logger = LoggerFactory.getLogger(this.getClass)

  /**
    * Log an error
    */
  def logError(error: String): Unit = {
    logger.error(error)
  }

  /**
    * Log a debug call
    */
  def logDebug(debug: String): Unit = {
    logger.debug(debug)
  }

  /**
    * Log information data
    */
  def logInfo(info: String): Unit = {
    logger.info(info)
  }
}
