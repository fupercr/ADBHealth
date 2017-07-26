/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.master

/**
  * The root policy determines how root servers are selected based on performance
  * criteria. For the moment, we provide minimum latency, random and round-robin.
  */
object ADBMasterPolicy extends Enumeration {
  type ADBMasterPolicy = Value

  val ShortestLatency = Value("shortest_latency")
  val RandomSelection = Value("random_selection")
  val RoundRobin = Value("round_robin")
}