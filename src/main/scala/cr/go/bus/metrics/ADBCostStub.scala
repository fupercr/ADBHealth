/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.metrics

/**
  * Cost stubs are used for the historical accounting in a possibly distributed
  * database. They are produced by a cost factory based on supplied parameters
  * via the configuration file.
  *
  * More importantly, two cost estimates are provided: one for the traditional
  * paper based process and one for the use of this bus.
  */
case class ADBCostStub(carbonAnlg: Double, timeAnlg: Double, moneyAnlg: Double,
                       energyADB: Double, timeADB: Double, moneyADB: Double) {

  /**
    * Functions for computing final savings. Possibly for logging functions in
    * the future.
    */
  def energyDifferential: Double = carbonAnlg - energyADB
  def timeDifferential: Double = timeAnlg - timeADB
  def moneyDifferential: Double = moneyAnlg - moneyADB

  /**
    * Compile differentials into a single object
    */
  def totalDifferential: ADBCostDifferential =
    ADBCostDifferential(energyDifferential, timeDifferential, moneyDifferential)

  /**
    *
    */

  /**
    * Convert to Json
    */
  def toJson(): Any = this.toJson()
}
