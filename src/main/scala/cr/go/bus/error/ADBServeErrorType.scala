/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.error

/**
  * Definition of possible errors while serving data
  **/
object ADBServeErrorType extends Enumeration {
  type ADBServeError = Value

  val BadRequest = Value("bad_request")
  val NotFound = Value("not_found")
  val Duplicate = Value("entity_exists")
  val HistoryError = Value("history_error")
  val CacheError = Value("cache_unreachable")
  val SourceError = Value("source_unreachable")
}