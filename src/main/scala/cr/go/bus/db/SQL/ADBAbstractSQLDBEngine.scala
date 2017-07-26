/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.db.SQL

/**
  * This class provides an abstraction for connecting with SQL resources.
  * We leave possibilities open for many types of SQL Engines with particular
  * requirements.
  *
  * The bus is a minimally invasive object in this stage of implementation. The
  * only operation that is allowed is the select query, which returns at most
  * an object at a time. While the latter may seem wasteful at present, this level
  * the expectation is that frequent queries will be stored across cache lines.
  */
abstract class ADBAbstractSQLDBEngine {
  /**
    * Select query
    */
  def select
}
