package guilgaly.ximmp.gui

import javafx.fxml.FXML
import javafx.scene.{control => jfxsc}

import guilgaly.ximmp.gui.controls.jfx.YieldingSlider

import scalafx.Includes._

class MediaControlBarController {

  @FXML private var backButton: jfxsc.Button = _
  @FXML private var playButton: jfxsc.Button = _
  @FXML private var forwardButton: jfxsc.Button = _
  @FXML private var searchBox: jfxsc.TextField = _
  @FXML private var seeker: YieldingSlider = _
  @FXML private var playTime: jfxsc.Label = _
  @FXML private var remainingTime: jfxsc.Label = _
  @FXML private var volumeControl: jfxsc.Slider = _

}
