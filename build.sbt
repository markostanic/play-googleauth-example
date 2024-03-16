name := """play-googleauth-example"""
organization := "rs.novalite"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.13"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test,
  "com.gu.play-googleauth" %% "play-v30" % "4.0.0"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "rs.novalite.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "rs.novalite.binders._"
