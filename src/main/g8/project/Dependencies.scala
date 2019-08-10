import sbt._

object Dependencies {
  val SCALA_VERSION = "2.12.9"

  lazy val jodaTime = "joda-time" % "joda-time" % "2.10.3"

  lazy val scalaTestPlusPlay = "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3"

  lazy val pegdown = "org.pegdown" % "pegdown" % "1.6.0"
}
