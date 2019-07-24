package bindings

import play.api.Application
import play.api.inject.{Binding, bind}
import play.api.inject.guice.{GuiceApplicationBuilder, GuiceableModule}

import scala.language.implicitConversions
import scala.reflect.ClassTag

object GuiceUtils {
  def application(guiceableModules: List[GuiceableModule], bindings: Binding[_]*): Application =
    GuiceApplicationBuilder()
      .bindings(guiceableModules: _*)
      .overrides(bindings)
      .build()

  def application(bindings: Binding[_]*): Application =
    application(List.empty, bindings: _*)

  implicit def guiceClassBinding[A : ClassTag, B <: A : ClassTag](binding: (Class[A], Class[B])): Binding[A] =
    bind[A].to[B]

  implicit def guiceInstanceBinding[A : ClassTag, B <: A](binding: (Class[A], B)): Binding[A] = {
    val (_, instance) = binding
    bind[A].toInstance(instance)
  }
}
