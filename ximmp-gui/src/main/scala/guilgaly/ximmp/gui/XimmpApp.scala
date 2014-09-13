package guilgaly.ximmp.gui

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafxml.core.FXMLView
import scalafxml.subcut.SubCutDependencyResolver

object XimmpApp extends JFXApp {

  /** Subcut configuration. */
  implicit val bindingModule = new XimmpConf

  stage = new JFXApp.PrimaryStage {
    title = "XIMMP"
    scene = new Scene(FXMLView.apply(getClass.getResource("Main.fxml"), new SubCutDependencyResolver))
    minWidth = 800
    minHeight = 600
  }
}
