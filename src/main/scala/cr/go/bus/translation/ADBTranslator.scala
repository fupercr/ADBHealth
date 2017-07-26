/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.translation

import java.util.UUID

import io.circe.Json

import scala.xml.NodeSeq
import collection.mutable.HashMap
import cats.data.StateT
import cats.std.option._
import cats.std.list._
import cats.syntax.traverse._
import io.circe.{Json, JsonObject}

/**
  * The translator trait provides objects and methods for translating between
  * standards. Only API agents and Miner agents are translators. A best practice
  * in the future is ensuring that only concrete implementations implement
  * abstract methods.
  */
trait ADBTranslator {
  /**
    * A translator holds two groups of standards. We will often encounter the case
    * of multipart JSON documents that take information from several elements of
    * a family of standards.
    *
    * Redundancy in the name provides look-up efficiency
    *
    * Keys are "standard+version"
    */
  val standardsFrom: HashMap[String, ADBAbstractTranslationStandard] = new HashMap[String, ADBAbstractTranslationStandard]()
  val standardsTo: HashMap[String, ADBAbstractTranslationStandard] = new HashMap[String, ADBAbstractTranslationStandard]()

  /**
    * A forward translation table and a backwards translation table are provided
    *
    * "standard+version" formats ensure
    */
  val translationForward: HashMap[String, String] = new HashMap[String, String]()
  val translationBackward: HashMap[String, String] = new HashMap[String, String]()

  /**
    * Translate using abstract standards. Return the corresponding
    * string or empty ("")
    */
  private def translateForward(term: String, fromSt: String, fromVer: String,
                       toSt: String, toVer: String): String = {
    /**
      * Check that the word exists
      */
    if (standardsFrom(fromSt+fromVer).member(term)) {
      if (translationForward.isDefinedAt(term)) {
        val translation = translationForward.get(term)

        if (standardsTo(toSt + toVer).member(translation.get))
          translation.get
        else
          "none"
      } else
        "none"

    } else
      "none"
  }

  /**
    * Translate using abstract standards. Return the corresponding
    * string or empty ("")
    */
  private def translateBackwards(term: String, fromSt: String, fromVer: String,
                       toSt: String, toVer: String): String = {
    /**
      * Check that the word exists
      */
    if (standardsFrom(fromSt+fromVer).member(term)) {
      if (translationBackward.isDefinedAt(term)) {
        val translation = translationBackward.get(term)

        if (standardsTo(toSt + toVer).member(translation.get))
          translation.get
        else
          "none"
      } else
        "none"
    } else
      "none"
  }

  /**
    * Register a source standard
    */
  def registerStandardFrom(std: ADBAbstractTranslationStandard) = {
    standardsFrom.put(std.getName, std)
  }

  /**
    * Register a source standard
    */
  def registerStandardTo(std: ADBAbstractTranslationStandard) = {
    standardsTo.put(std.getName, std)
  }

  /**
    * Register a new association in both tables. This method will
    * be used as well for filling the tables in. If a previous translation
    * exists, it will be replaced by this one.
    */
  def registerTranslation(termFrom: String, stdFrom: String, verFrom: String,
                          termTo: String, stdTo: String, verTo: String): Unit = {
    if (standardsFrom.isDefinedAt(stdFrom + verFrom) &&
      standardsTo.isDefinedAt(stdTo + verTo)) {
      if (standardsFrom(stdFrom + verFrom).member(termFrom) &&
        standardsTo(stdTo + verTo).member(termTo)) {
        translationForward.put(termTo, termFrom)
        translationBackward.put(termFrom, termTo)
      }
    }
  }

  /**
    * Load from XML.
    *
    * This must be implemented by topmost concrete standards
    */
  def loadTableXML(file: NodeSeq): Unit

  /**
    * Load from JSON.
    *
    * This must be implemented by topmost concrete standards
    */
  def loadTableJson(file: Json): Unit

  /**
    * Load from CVS.
    *
    * This must be implemented by topmost concrete standards
    */
  def loadTableCVS(file: String): Unit

  /**
    * Translate a Json object attribute by attribute forward
    */
  def translateJsonForward(data: Json): Json = {
    //todo.implement
    Json.obj()
  }

  /**
    * Translate a Json object attribute by attribute backwards
    */
  def translateJsonBackwards(data: Json): Json = {
    //todo.implement
    data
  }

}
