package modules

import play.api.inject.{Binding, bind}

import scala.language.implicitConversions
import scala.reflect.ClassTag

object GuiceBindings {
  implicit def guiceClassBinding[A : ClassTag, B <: A : ClassTag](binding: (Class[A], Class[B])): Binding[A] =
    bind[A].to[B]

  implicit def guiceInstanceBinding[A : ClassTag, B <: A](binding: (Class[A], B)): Binding[A] = {
    val (_, instance) = binding
    bind[A].toInstance(instance)
  }
}
