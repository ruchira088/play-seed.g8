package modules

import config.SystemUtilities
import modules.GuiceBindings._
import play.api.{Configuration, Environment}
import play.api.inject.{Binding, Module}

class CoreModule extends Module {
  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] =
    List {
      classOf[SystemUtilities] -> SystemUtilities
    }
}
