import sbt._

object Dependencies {
  val SCALA_VERSION = "2.13.1"

  lazy val kindProjector = "org.typelevel" %% "kind-projector" % "0.10.3"

  lazy val jodaTime = "joda-time" % "joda-time" % "2.10.5"

  lazy val scalaTestPlusPlay = "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3"

  lazy val pegdown = "org.pegdown" % "pegdown" % "1.6.0"
}
