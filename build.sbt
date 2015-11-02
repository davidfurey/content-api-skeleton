organization := "scala-school"

name := "content-api-skeleton"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "com.gu" %% "content-api-client" % "7.3",
  // Test dependencies
  "org.specs2" %% "specs2" % "2.3.12" % "test"
)
