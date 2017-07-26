/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.bus.translation

import io.circe.Json

import scala.collection.mutable.HashSet
import scala.xml.NodeSeq


/**
  * Translation standards are classes that allow representing terminological
  * sequences for objects. This is an abstract class, and any other class that
  * inherits it should remain abstract as a best software engineering practice.
  *
  * Abstraction may be read as this: a class is concrete if and only if it
  * implements a classification leave in the family of standards.
  */
abstract class ADBAbstractTranslationStandard(name: String,
                                              purpose: String, version: String) {
  /**
    * The lexicon holds all known words for a given standard and version. Two standards
    * are from the same family only if they have the same name, but are not guaranteed
    * to interoperate. We peovide a best guess set for a term in another standard.
    *
    * The family field is used by derived classes to trace genealogy
    */
  var lexicon: HashSet[String] = new HashSet[String]()
  var family: String = ""

  /**
    * Intersect two standards
    */
  def getSharedTerms(standard: ADBAbstractTranslationStandard): HashSet[String] = {
    lexicon.intersect(standard.lexicon)
  }

  /**
    * Obtain unique terms in this standard
    */
  def getUniqueTerms(standard: ADBAbstractTranslationStandard): HashSet[String] = {
    lexicon.diff(standard.lexicon)
  }

  /**
    * Check for membership
    */
  def member(term: String): Boolean = {
    lexicon.contains(term)
  }

  /**
    * Manually add one term
    */
  def add(term: String): Boolean = {
    lexicon.add(term)
  }

  /**
    * Manually add many terms
    */
  def addMany(terms: HashSet[String]) = {
    val iterator = terms.iterator

    while (iterator.hasNext)
      lexicon.add(iterator.next())
  }

  /**
    * Append a new family standard denotation
    */
  protected def appendGenealogy(branch: String): Unit = {
    family = family.concat(branch)
  }

  /**
    * Obtain the genealogy of a class
    *
    * This method relies on the speification taken care of by the
    * abstract and concrete classes that append suffixes as they
    * are constructed.
    */
  def getGeneaology: String = this.family

  /**
    * Obtain the name of the standard
    */
  def getName(): String = this.name

  /**
    * Obtain the purpose of the standard
    */
  def getPurpose(): String = this.purpose

  /**
    * Obtain the version of the standard
    */
  def getVersion(): String = this.version

  /**
    * Load from XML.
    *
    * Must be implemented by topmost concrete standards
    */
  def loadStandardXML(file: NodeSeq): Unit

  /**
    * Load from JSON.
    *
    * Must be implemented by topmost concrete standards
    */
  def loadStandardJson(file: Json): Unit

  /**
    * Load from CVS.
    *
    * Must be implemented by topmost concrete standards
    */
  def loadStandardCVS(file: String): Unit
}
