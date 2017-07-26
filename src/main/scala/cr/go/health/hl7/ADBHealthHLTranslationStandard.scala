/**
  * Copyright (c) 2017 The Republic of Costa Rica. All rights reserved.
  * Author: Santiago Nuñez Corrales (dev@fuper.cr)
  *
  * ADB-Health: Agent Distributed Bus - Health sector initial implementation
  **/
package cr.go.health.hl7

import cr.go.bus.translation.ADBAbstractTranslationStandard

/**
  * This class provides an abstract form for all top level concrete
  * HL7 standards and abstract families of HL7 member standardss
  */
abstract class ADBHealthHLTranslationStandard (name: String, purpose: String, version: String)
  extends ADBAbstractTranslationStandard(name: String, purpose: String, version: String) {
  /**
    * Update toplevel geneaology to indicate HL7
    */
  appendGenealogy(".HL7")

}
