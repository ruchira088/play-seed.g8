import Dependencies._

lazy val root =
  (project in file("."))
    .enablePlugins(PlayScala, BuildInfoPlugin)
    .settings(
      name := "$name;format="normalize"$",
      organization := "com.ruchij",
      version := "0.0.1",
      maintainer := "me@ruchij.com",
      scalaVersion := SCALA_VERSION,
      buildInfoKeys := BuildInfoKey.ofN(name, organization, version, scalaVersion, sbtVersion),
      buildInfoPackage := "com.eed3si9n.ruchij",
      scalacOptions ++= Seq("-Xlint", "-feature"),
      topLevelDirectory := None,
      addCompilerPlugin(kindProjector),
      addCompilerPlugin(scalaTypedHoles),
      testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-results/unit-tests"),
      libraryDependencies ++= rootDependencies ++ rootTestDependencies.map(_ % Test)
    )

lazy val rootDependencies = Seq(guice, jodaTime)

lazy val rootTestDependencies = Seq(scalaTestPlusPlay, pegdown, flexMarkAll)

addCommandAlias("testWithCoverage", "; coverage; test; coverageReport")
