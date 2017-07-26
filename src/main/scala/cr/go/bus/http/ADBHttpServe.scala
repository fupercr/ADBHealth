/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.http

import akka.event.slf4j.SLF4JLogging
import cr.go.bus.error.ADBServeError
import io.circe.Json
import net.liftweb.json.Serialization._
import spray.http._
import spray.routing._

/**
  * This trait implements basic elements for HTTP request handling.
  *
  */
trait ADBHttpServe extends HttpService with SLF4JLogging {
  implicit val executionContext = actorRefFactory.dispatcher

  implicit val customRejectionHandler = RejectionHandler {
    case rejections => mapHttpResponse { response: HttpResponse =>
      response.withEntity(HttpEntity(ContentType(MediaTypes.`application/json`), Json.obj("error" -> response.entity.toString)))
    } {
      RejectionHandler.Default(rejections)
    }
    //todo.solve
  }

  /**
    * We leave the rest implementation value to the concrete entities.
    */
  val rest: Route

  /**
    * Handles an incoming request and create valid response for it.
    */
  protected def handleRequest(ctx: RequestContext, successCode: StatusCode = StatusCodes.OK)(action: => Either[ADBServeError, _]) = {
    action match {
      case Right(result: Object) => ctx.complete(successCode, result.toString)
      case Left(error: ADBServeError) => ctx.complete(error.getStatusCode, write(Map("error" -> error.message)))
      case _ => ctx.complete(StatusCodes.InternalServerError)
    }
    //todo.solve
  }
}
