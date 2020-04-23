import sbt._

object Dependencies {
  val SCALA_VERSION = "2.13.2"

  lazy val kindProjector = "org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full

  lazy val scalaTypedHoles = "com.github.cb372" % "scala-typed-holes" % "0.1.2" cross CrossVersion.full

  lazy val jodaTime = "joda-time" % "joda-time" % "2.10.5"

  lazy val scalaTestPlusPlay = "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0"

  lazy val pegdown = "org.pegdown" % "pegdown" % "1.6.0"
}
