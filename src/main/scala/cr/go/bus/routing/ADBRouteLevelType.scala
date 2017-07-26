/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.routing

/**
  * Route levels define the depth at which the framework can operate.
  *
  * Services are structured in a DNS-like fashion depending on their meaning:
  *
  * master - the main registry who provides root server lists to all. There may
  *        be three replicated master instances.
  * root - level of the API for the whole state, only a few qualified instances
  *        exist for load balancing purposes. All instances receive registration
  *        requests of new services from other agents. The authoritative list of
  *        roots is from a file distributed by a master agent. This master agent
  *        is intended to reside at the Ministerio de Ciencia, Tecnologia y
  *        Telecomunicaciones until a Agencia de Tecnologias Digitales exists.
  * sector - the Ministerio de Planificacion of Costa Rica establishes 24 sectors
  *          where institutions are grouped.
  * agency - institutions are listed here, without distinction by which part of
  *          the public sector they are in or their autonomy; all institutions
  *          are first class citizens.
  * service - service level is the last level where agents have cache access
  *           and data access is pushed transparently in order to sustain the
  *           necessary efficiency thanks to the memory hierarchy.
  * miner - miners implement ADBAbstractSource attributes and methods, and obtain
  *         data directly from the source. These need to be constructed by the
  *         organizations that have data.
  * api - API agents are special insofar they provide the point of entry for the
  *       general API. These run on a server where internal applications have
  *       access rights. There is always only one agent at this level.
  */
object ADBRouteLevelType extends Enumeration {
  type ADBRouteLevelType = Value

  val Master = Value("master")
  val Api = Value("api")
  val PkiApi = Value("pkiapi")
  val Root = Value("root")
  val Sector = Value("sector")
  val Agency = Value("agency")
  val Service = Value("service")
  val Miner = Value("miner")
  val PkiMiner = Value("pkiminer")
  val Unknown = Value("unknown")
}