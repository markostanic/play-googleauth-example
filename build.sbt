import com.typesafe.sbt.packager.docker.DockerChmodType.UserGroupWriteExecute
import com.typesafe.sbt.packager.docker.DockerPermissionStrategy.CopyChown

name := """play-googleauth-example"""
organization := "rs.novalite"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, DockerPlugin)

scalaVersion := "2.13.13"

libraryDependencies ++= Seq(
  ws,
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test,
  "com.gu.play-googleauth" %% "play-v30" % "4.0.0"
)

dockerBaseImage := "amazoncorretto:17-alpine"
dockerExposedPorts := Seq(9000)
dockerChmodType := UserGroupWriteExecute
dockerPermissionStrategy := CopyChown
dockerUpdateLatest := true
dockerEntrypoint := Seq(
  "java",
  "-Duser.dir=/opt/docker",
  "-cp",
  "conf/:lib/*",
  "-Dhttp.port=9000"
)
dockerCmd := Seq("play.core.server.ProdServerStart")
