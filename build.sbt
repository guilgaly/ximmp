import sbt.Keys._

// ################################################# PROJECT #################################################

name := "ximmp"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  // ScalaFX
  "org.scalafx" %% "scalafx" % "8.0.20-R6",
  // ScalaFXML
//  "org.scalafx" %% "scalafxml-core" % "0.2.2-SNAPSHOT",
//  "org.scalafx" %% "scalafxml-subcut" % "0.2.2-SNAPSHOT",
  // DI/IoC
  "com.escalatesoft.subcut" %% "subcut" % "2.1",
  // Logs
  "org.log4s" %% "log4s" % "1.1.3",
  "org.slf4j" % "slf4j-simple" % "1.7.7",
  // Tests
  "org.scalatest" %% "scalatest" % "2.2.2" % "test",
  // Compiler plugins
  compilerPlugin("com.escalatesoft.subcut" %% "subcut" % "2.1"),
  compilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)
)

fork := true

fork in Test := true


// ######################################## SBT PLUGINS CONFIGURATION ########################################

/* For dependency-tree, etc.
 * Common tasks:
 * - dependency-graph : Shows an ASCII graph of the project's dependencies on the sbt console
 * - dependency-tree : Shows an ASCII tree representation of the project's dependencies
 * - what-depends-on <organization> <module> <revision> : Find out what depends on an artifact.
 *   Shows a reverse dependency tree for the selected module.
 */
net.virtualvoid.sbt.graph.Plugin.graphSettings

/*
 * Native packaging with sbt-javafx: package with the package-javafx SBT task. Will create native packages for
 * all supported platforms (depending on the platform used for building). Eg. on Mac OS X, will create a .app
 * application, and will also package it in a .dmg disk image and a .pkg installer.
 *
 * Note: There are requirements for building various types of packages. Per Oracle's doc:
 * - EXE: Windows, Inno Setup 5 or later
 * - MSI: Windows, WiX 3.0 or later
 * - APP/DMG/PKG: Mac OS X, Xcode (Xcode is not mentionned in Oracle's doc, but there's an error otherwise!)
 * - RPM: Linux, RPMBuild
 * - DEB: Linux, Debian packaging tools
 */
jfxSettings

JFX.mainClass := Some("guilgaly.ximmp.gui.XimmpApp")

JFX.nativeBundles := "all"

JFX.vendor := "Guillaume Galy"

JFX.title := "XIMMP"

JFX.description := "XIMMP Is More than just a Music Player"

JFX.copyright := "Guillaume Galy 2014"

JFX.license := "GPL v3"

JFX.appVersion := "0.0.1"

JFX.appName := "XIMMP"

JFX.licenseFile := Some(baseDirectory.value / "LICENSE")

JFX.verbose := true