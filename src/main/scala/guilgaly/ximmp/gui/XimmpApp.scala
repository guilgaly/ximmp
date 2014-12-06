package guilgaly.ximmp.gui

import guilgaly.ximmp.util.Logging

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene

import javafx.{scene => jfxs}
import javafx.{fxml => jfxf}

object XimmpApp extends JFXApp with Logging {

  logger.debug("Start")

  val loader = new jfxf.FXMLLoader(getClass.getResource("/fxml/Main.fxml"))
  val root = loader.load[jfxs.Parent]
  val controller = loader.getController[MainController]

  stage = new JFXApp.PrimaryStage {
    title = "XIMMP"
    scene = new Scene(root)
    minWidth = 800
    minHeight = 600
  }
}
