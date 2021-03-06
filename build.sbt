name := "atto"

description := "functional parser combinators for scala"

organization in ThisBuild := "org.tpolecat"

version in ThisBuild := "0.4.1-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.0"

crossScalaVersions in ThisBuild := Seq("2.10.4", "2.11.0")

licenses in ThisBuild ++= Seq(
	("MIT", url("http://opensource.org/licenses/MIT")),
	("BSD New", url("http://opensource.org/licenses/BSD-3-Clause"))
)

scalacOptions in ThisBuild ++= Seq(
	"-feature", 
	"-deprecation", 
	"-Yno-adapted-args",
	"-Ywarn-value-discard", 
	// "-Ywarn-dead-code", // busted in 2.11 it seems
	"-Xlint",
	"-Xfatal-warnings",
  "-unchecked"
)

// Let's be even more picky in non-test code
scalacOptions in compile ++= Seq(
	"-Yno-imports",
	"-Ywarn-numeric-widen"
)


lazy val core = project.in(file("core"))

lazy val spire = project.in(file("spire")).dependsOn(core)

// On hold waiting on streams for 2.11 + 7.1
// lazy val stream = project.in(file("stream")).dependsOn(core)

lazy val example = project.in(file("example")).dependsOn(core, spire) //, stream)

publishArtifact := false

