/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.metrics

import cr.go.bus.entities.ADBJsonable
import io.circe.Json

case class ADBCostDifferential(cdiff: Double, tdiff: Double, mdiff: Double)
                              extends ADBJsonable{

  /**
    * Obtain distance with another differential using an Euclidean distance
    */
  def distance(other: ADBCostDifferential) : Double =
    math.sqrt(cdiff*cdiff + tdiff*tdiff + mdiff*mdiff)

  /**
    * Obtain the JSON representation for a differential
    */
  override def toJson() : Json = this.toJson()
}
