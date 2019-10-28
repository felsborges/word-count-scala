ThisBuild / scalaVersion := "2.12.10"
ThisBuild / organization := "DB Server"

lazy val wordCount = (project in file("."))
    .settings(
        name := "Word Count",
        libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
        libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.9",

    )