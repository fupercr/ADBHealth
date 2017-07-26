/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.metrics

import java.time.Instant

import cr.go.bus.config.ADBConfigurable

/**
  * This object uses the configuration file to generate carbon, time and money
  * metrics for policy measurement and assessment.
  */
object ADBCostFactory extends ADBConfigurable {
  var timea: Double = 0
  var timeb: Double = 0
  /**
    * Helper function to compute carbon metrics for analog cost
    * Traditional metrics are taken to be canonical.
    */
  private def carbonAnalogCost(): Double = {
    carbonAnalogEnergyPerSec * timeAnalogLabourPerSec +
      carbonAnalogLabourPerSec * timeAnalogLabourPerSec +
      carbonAnalogTransportPerSec * timeAnalogTransportPerSec +
      carbonAnalogPaper * carbonAnalogPaperUnits
  }

  /**
    * Helper function to compute time metrics for the analog cost model
    */
  private def timeAnalogCost(): Double = {
    timeAnalogTransportPerSec+timeAnalogLabourPerSec
  }

  /**
    * Helper function to compute financial metrics for the analog cost
    * model
    */
  private def moneyAnalogCost(): Double = {
    moneyAnalogEnergyPerSec * timeAnalogLabourPerSec +
      moneyAnalogLabourPerSec * timeAnalogLabourPerSec +
      moneyAnalogTransportPerSec * timeAnalogTransportPerSec +
      moneyAnalogPaper * moneyAnalogPaperUnits
  }

  /**
    * Helper function to compute carbon metrics for the digital case
    */
  private def carbonDigitalCost(): Double = {
    carbonDigitalEnergyPerSec * timeDigitalCost() +
      carbonDigitalTransportPerSec * timeDigitalCost()
  }

  /**
    * Helper function to compute time metrics for the digital cost model
    */
  private def timeDigitalCost(): Double = {
    timeb-timea
  }

  /**
    * Helper function to compute financial metrics for the digital cost
    * model
    */
  private def moneyDigitalCost(): Double = {
    moneyDigitalEnergyPerSec * timeDigitalCost() +
      moneyDigitalTransportPerSec * timeDigitalCost()
  }

  /**
    * Compute the cost of a basic operation.
    */
  def computeBasicCost(): ADBCostStub = {
    new ADBCostStub(carbonAnalogCost(),timeAnalogCost(),moneyAnalogCost(),
      carbonDigitalCost(), timeDigitalCost(),
      moneyDigitalCost())
  }

  /**
    * Compute the cost of an accumulated operation. This method is called
    * at every hopping step.
    */
  def computeAccumulatedCost(previous: ADBCostStub): ADBCostStub = {
    new ADBCostStub(previous.carbonAnlg + carbonAnalogCost(),
      previous.timeAnlg + timeAnalogCost(),
      previous.moneyAnlg + moneyAnalogCost(),
      carbonDigitalCost(), timeDigitalCost(),
      moneyDigitalCost())
  }

  /**
    * Start chronometer
    */
  def chronoStart(): Unit = {
    timea = Instant.now.toEpochMilli/1000.0
  }

  /**
    * End chronometer
    */
  def chronoEnd(): Unit = {
    timeb = Instant.now.toEpochMilli/1000.0
  }
}
