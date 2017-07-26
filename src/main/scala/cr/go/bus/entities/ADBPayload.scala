/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.entities

import language.dynamics
import scala.reflect.macros.blackbox.Context
import scala.language.experimental.macros

/**
  * Handling intermediate JSON representations for CouchDBs is tricky in terms
  * of structure. Our CouchDB handler requires passing an object to store, read
  * or delete information. We that through backbox macros that strictly follow
  * the data type.
  */
class ADBPayload extends Dynamic {
  def applyDynamic[A](name: String)(args: A*): A = macro ADBPayload.applyDynamic[A]
}

object ADBPayload {

  def applyDynamic[A : c.WeakTypeTag](c: Context)(name: c.Expr[String])(args: c.Expr[A]*) = {
    import c.universe._

    val Literal(Constant(defName: String)) = name.tree

    val res = defName match {
      case _ =>
        val seq = args map(_.tree) map { case Literal(Constant(c)) => c }
        c.abort(c.enclosingPosition, s"method '$defName' with args ${seq.mkString("'", "', '", "'")} doesn't exist")
    }
    c.Expr(Literal(Constant(res)))
  }
}