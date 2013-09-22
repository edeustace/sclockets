import sbt._
import sbt.Keys._

object Build extends sbt.Build {

  object Dependencies {
    val specs2 = "org.specs2" %% "specs2" % "2.2.2"
    val grizzled = "org.clapper" % "grizzled-scala_2.10" % "1.1.4"
    val all = Seq()
  }

  import Dependencies._

  scalaVersion in ThisBuild := "2.10.2"
  organization in ThisBuild := "com.ee"
  version in ThisBuild := "0.1-SNAPSHOT"
  libraryDependencies in ThisBuild ++= Seq(grizzled, specs2 % "test")

  lazy val core = Project(
    id = "sclockets-core",
    base = file("modules/core")
  ).settings( libraryDependencies ++= Seq(specs2))

  lazy val sclockets = Project(
    id = "sclockets",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(name := "sclockets")
  ).dependsOn(core)
}
