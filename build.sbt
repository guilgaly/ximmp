import sbt.Keys._


// #################### PROJECTS ####################

// Aggregates all projects
lazy val ximmp = ximmpProject("ximmp", file(".")).aggregate(ximmpGui, ximmpControls, ximmpCore)

// Main GUI application
lazy val ximmpGui = (
  fxmlXimmpProject("ximmp-gui")
  dependsOn(ximmpControls)
)

// Custom controls for ximmpGui - publish this to import in Scene Builder
lazy val ximmpControls = (
  scalafxXimmpProject("ximmp-controls")
  dependsOn(ximmpCore)
)

// Core non-GUI functionnality
lazy val ximmpCore = scalafxXimmpProject("ximmp-core")


// #################### UTILITY METHODS ####################

def ximmpProject(name: String, file: File): Project = (
  Project(name, file)
  settings(
  	version := "0.0.1-SNAPSHOT",
    organization := "guilgaly",
    scalaVersion := "2.11.2",
    // Set the prompt (for this build) to include the project id.
    shellPrompt := { state => System.getProperty("user.name") + ":" + Project.extract(state).currentRef.project + "> " }
  )
)

def scalafxXimmpProject(name: String): Project = (
  ximmpProject(name, file(name))
  settings(
    libraryDependencies ++= Seq(
      // ScalaFX
      "org.scalafx" %% "scalafx" % "8.0.5-R5",
      // Logs
      "org.log4s" %% "log4s" % "1.0.3",
      "org.slf4j" % "slf4j-simple" % "1.7.7",
      // Tests
      "org.scalatest" %% "scalatest" % "2.2.1" % "test"
    ),
    // Run in separate VM, so there are no issues with double initialization of JavaFX
    fork := true,
    fork in Test := true
  )
)

def fxmlXimmpProject(name: String): Project = (
  scalafxXimmpProject(name)
  settings(
    libraryDependencies ++= Seq(
      "org.scalafx" %% "scalafxml-core" % "0.2.2-SNAPSHOT",
      "org.scalafx" %% "scalafxml-subcut" % "0.2.2-SNAPSHOT",
      // DI/IoC
      "com.escalatesoft.subcut" %% "subcut" % "2.1",
      // Compiler plugins
      compilerPlugin("com.escalatesoft.subcut" %% "subcut" % "2.1"),
      compilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)
    )
  )
)