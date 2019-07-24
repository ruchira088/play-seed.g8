package modules

import config.SystemUtilities
import play.api.{Configuration, Environment}
import play.api.inject.{Binding, Module}

class CoreModule extends Module {
  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] =
    List {
      bind[SystemUtilities].to(SystemUtilities)
    }
}
