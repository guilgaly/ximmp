// for dependency-tree, etc.
net.virtualvoid.sbt.graph.Plugin.graphSettings


/*
 * Native packaging with sbt-javafx: package with the package-javafx SBT task.
 * Will create native packages for all supported platforms (depending on the platform used for building).
 * Eg. on Mac OS X, will create a .app application, and will also package it in a dmg disk image and a pkg installer.
 *
 * Note: There are requirements for building various types of packages. Per Oracle's doc:
 * - EXE: Windows, Inno Setup 5 or later
 * - MSI: Windows, WiX 3.0 or later
 * - DMG: Mac OS X, Xcode (Xcode is not mentionned in Oracle's doc, but there's an error otherwise!)
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