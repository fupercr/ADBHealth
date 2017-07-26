/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.api

import cr.go.bus.root.ADBRootPolicy
import cr.go.bus.master.ADBMasterPolicy
import io.circe.Json
import scala.collection.mutable.HashMap

/**
  * The API trait provides data structures and methods to determine which nodes
  * are Roots thanks to a call from a master node. There exists a single API
  * for all applications. There is a fixed array of three master nodes. This
  * responds to a State design where at most three institutions should have the
  * responsibility of holding digital data. Current settings indicate that
  * data governance should proceed hierarchically with limited replication
  * redundancy.
  */
trait ADBApi {
  val masters: HashMap[String, Double] = HashMap[String, Double]()
  val roots: HashMap[String, Double] = HashMap[String, Double]()

  val mastersPolicy: ADBMasterPolicy.Value
  val rootsPolicy: ADBRootPolicy.Value

  /**
    * Ping one master based on a policy
    */
  protected def pingMaster(): Long = {
    //todo.implement
    0
  }

  /**
    * Choose a root based on a policy
    */
  protected def chooseRoot(): String = {
    //todo.implement
    ""
  }

  /**
    * Ping a root
    */
  protected def pingRoot(root: String): Long = {
    //todo.implement
    0
  }

  /**
    * Obtain root nodes from the master
    */
  def getRoots(): Unit = {
    //todo.implement
  }

  /**
    * Send a new query with an API agent address (IP:port), a service name
    * and a JSON object that has a standard and a version.
    */
  def sendQuery(service:String, std: String, stdVersion: String, qry: Json): Unit = {
    //todo.implement
  }

}
