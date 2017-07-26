/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.config

/**
  * All agents obtain their initialization parameters from a file named
  * application.conf. An example can be found
  */

import com.typesafe.config.{Config, ConfigFactory}

import util.Try

/**
  * The configurable trait endows a class with valued obtained from an
  * application.conf file during initialization time.
  */
trait ADBConfigurable {

  val config: Config = ConfigFactory.load()

  /**
    * Obtain all agent related parameters
    **/
  lazy val agentName = Try(config.getString("agent.name")).getOrElse("default")
  lazy val agentHost = Try(config.getString("agent.host")).getOrElse("localhost")
  lazy val agentPort:Int = Try(config.getInt("agent.port")).getOrElse(8080)
  lazy val agentLevel = Try(config.getString("agent.level")).getOrElse("localhost")

  /**
    * Obtain all parent agent related parameters
    **/
  lazy val parentName = Try(config.getString("parent.name")).getOrElse("")
  lazy val parentHost = Try(config.getString("parent.host")).getOrElse("")
  lazy val parentPort = Try(config.getInt("parent.port")).getOrElse(0)

  /**
    * Obtain all history db related parameters
    **/
  lazy val historyHost = Try(config.getString("history.host")).getOrElse("localhost")
  lazy val historyPort:Int = Try(config.getInt("history.port")).getOrElse(0)
  lazy val historyName = Try(config.getString("history.name")).getOrElse("")
  lazy val historyUser = Try(config.getString("history.user")).getOrElse("")
  lazy val historyPswd = Try(config.getString("history.pswd")).getOrElse("")
  lazy val historyHttps = Try(config.getBoolean("history.https")).getOrElse(false)

  /**
    * Obtain all cache db related parameters
    **/
  lazy val cacheHost = Try(config.getString("cache.host")).getOrElse("")
  lazy val cachePort:Int = Try(config.getInt("cache.port")).getOrElse(0)
  lazy val cacheName = Try(config.getString("cache.name")).getOrElse("")
  lazy val cacheUser = Try(config.getString("cache.user")).getOrElse("")
  lazy val cachePswd = Try(config.getString("cache.pswd")).getOrElse("")
  lazy val cacheMaxsize:Int = Try(config.getInt("cache.maxsize")).getOrElse(0)
  lazy val cacheHttps = Try(config.getBoolean("cache.https")).getOrElse(false)

  /**
    * Obtain all miner related parameters
    * A TTL indicates the time a query remains valid in seconds. One hour is a
    * reasonable quantity. No user is required as it assumes a Web service of
    * minimal contact.
    **/
  lazy val minerHost = Try(config.getString("miner.host")).getOrElse("localhost")
  lazy val minerPort:Int = Try(config.getInt("miner.port")).getOrElse(0)
  lazy val minerName = Try(config.getString("miner.name")).getOrElse("")
  lazy val minerTTL:Int = Try(config.getInt("miner.ttl")).getOrElse(3600)
  lazy val minerUser = Try(config.getString("miner.user")).getOrElse("")
  lazy val minerPswd = Try(config.getString("miner.pswd")).getOrElse("")
  lazy val minerType = Try(config.getString("miner.type")).getOrElse("")
  lazy val minerPki = Try(config.getString("miner.pki")).getOrElse("")

  /**
    * Obtain all root agents from the master's nodes. All master nodes
    * have the same configuration.
    */
  lazy val masterRootA = Try(config.getString("master.roota")).getOrElse("")
  lazy val masterRootB = Try(config.getString("master.rootb")).getOrElse("")
  lazy val masterRootC = Try(config.getString("master.rootc")).getOrElse("")
  lazy val masterRootD = Try(config.getString("master.rootd")).getOrElse("")
  lazy val masterRootE = Try(config.getString("master.roote")).getOrElse("")
  lazy val masterRootAPort = Try(config.getString("master.rootaport")).getOrElse("")
  lazy val masterRootBPort = Try(config.getString("master.rootbport")).getOrElse("")
  lazy val masterRootCPort = Try(config.getString("master.rootcport")).getOrElse("")
  lazy val masterRootDPort = Try(config.getString("master.rootdport")).getOrElse("")
  lazy val masterRootEPort = Try(config.getString("master.rooteport")).getOrElse("")

  /**
    * Obtain addresses for all mater nodes, API agent
    */
  lazy val apiMasterA = Try(config.getString("api.mastera")).getOrElse("")
  lazy val apiMasterB = Try(config.getString("api.masterb")).getOrElse("")
  lazy val apiMasterC = Try(config.getString("api.masterc")).getOrElse("")
  lazy val apiMasterAPort = Try(config.getInt("api.masteraport")).getOrElse(0)
  lazy val apiMasterBPort = Try(config.getInt("api.masterbport")).getOrElse(0)
  lazy val apiMasterCPort = Try(config.getInt("api.mastercport")).getOrElse(0)
  lazy val apiPki = Try(config.getString("api.pki")).getOrElse("")

  /**
    * Carbon cost model parameters
    */
  lazy val carbonDigitalEnergyPerSec:Double = Try(config.getDouble("carbonmodel.digitalenrsec")).getOrElse(0.0)
  lazy val carbonDigitalTransportPerSec:Double = Try(config.getDouble("carbonmodel.digitaltrnsec")).getOrElse(0.0)
  lazy val carbonAnalogEnergyPerSec:Double = Try(config.getDouble("carbonmodel.analogenrsec")).getOrElse(0.0)
  lazy val carbonAnalogTransportPerSec:Double = Try(config.getDouble("carbonmodel.analogtrnsec")).getOrElse(0.0)
  lazy val carbonAnalogLabourPerSec:Double = Try(config.getDouble("carbonmodel.analogopssec")).getOrElse(0.0)
  lazy val carbonAnalogPaper:Double = Try(config.getDouble("carbonmodel.analogppr")).getOrElse(0.0)
  lazy val carbonAnalogPaperUnits:Int = Try(config.getInt("carbonmodel.analogpprunt")).getOrElse(0)

  /**
    * Time cost model parameters
    */
  lazy val timeAnalogTransportPerSec:Double = Try(config.getDouble("timemodel.analogtrnsec")).getOrElse(0.0)
  lazy val timeAnalogLabourPerSec:Double = Try(config.getDouble("timemodel.analogopssec")).getOrElse(0.0)

  /**
    * Money cost model parameters
    */
  lazy val moneyDigitalEnergyPerSec:Double = Try(config.getDouble("moneymodel.digitalenrsec")).getOrElse(0.0)
  lazy val moneyDigitalTransportPerSec:Double = Try(config.getDouble("moneymodel.digitaltrnsec")).getOrElse(0.0)
  lazy val moneyAnalogEnergyPerSec:Double = Try(config.getDouble("moneymodel.analogenrsec")).getOrElse(0.0)
  lazy val moneyAnalogTransportPerSec:Double = Try(config.getDouble("moneymodel.analogtrnsec")).getOrElse(0.0)
  lazy val moneyAnalogLabourPerSec:Double = Try(config.getDouble("moneymodel.analogopssec")).getOrElse(0.0)
  lazy val moneyAnalogPaperUnits:Int = Try(config.getInt("moneymodel.analogpprunt")).getOrElse(0)
  lazy val moneyAnalogPaper:Double = Try(config.getDouble("moneymodel.analogppr")).getOrElse(0.0)

  /**
    * Translation between standards
    */
  lazy val translationFrom = Try(config.getString("translation.from")).getOrElse("none")
  lazy val translationTo = Try(config.getString("translation.to")).getOrElse("none")
}
