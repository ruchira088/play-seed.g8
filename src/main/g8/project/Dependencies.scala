import sbt._

object Dependencies {
  val SCALA_VERSION = "2.13.3"

  lazy val kindProjector = "org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full

  lazy val scalaTypedHoles = "com.github.cb372" % "scala-typed-holes" % "0.1.5" cross CrossVersion.full

  lazy val jodaTime = "joda-time" % "joda-time" % "2.10.6"

  lazy val scalaTestPlusPlay = "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0"

  lazy val flexMarkAll = "com.vladsch.flexmark" % "flexmark-all" % "0.35.10"

  lazy val pegdown = "org.pegdown" % "pegdown" % "1.6.0"
}
