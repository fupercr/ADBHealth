/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.error

import spray.http.{StatusCodes,StatusCode}

/**
  * Case for handling serve errors
  **/
case class ADBServeError(message: String, errorType: ADBServeErrorType.Value) {
  def getStatusCode: StatusCode = {
    ADBServeErrorType.withName(this.errorType.toString) match {
      case ADBServeErrorType.BadRequest => StatusCodes.BadRequest
      case ADBServeErrorType.NotFound => StatusCodes.NotFound
      case ADBServeErrorType.Duplicate => StatusCodes.Forbidden
      case _ => StatusCodes.InternalServerError
    }
  }
}


