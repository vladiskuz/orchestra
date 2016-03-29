package org.orchestra.config

import net.jcazevedo.moultingyaml.DefaultYamlProtocol

/**
  * Created by tdurakov on 20.03.16.
  */

trait ConfigYamlProtocol extends DefaultYamlProtocol {
  implicit val cloudFormat = yamlFormat4(Cloud)
  implicit val vmTemplateFormat = yamlFormat4(VmTemplate)
  implicit val scenarioFormat = yamlFormat3(Scenario)
  implicit  val backendFormat = yamlFormat2(Backend)
  implicit val configFormat = yamlFormat5(Config)
}


final case class Cloud(username: String, projectname: String, password: String, auth_url: String)
final case class VmTemplate(flavorRef: String, networkRef: String, imageRef: String, name_template: String)
final case class Scenario(id: Int, parallel: Int, steps:List[String])
final case class Backend(influx_host: String, database: String)
final case class Config (cloud: Cloud, vm_template: VmTemplate, run_number: Int, backend: Backend, scenarios:Map[String, Scenario])