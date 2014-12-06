package guilgaly.ximmp.gui.controls.sfx

import guilgaly.ximmp.gui.controls.jfx

import scala.language.implicitConversions
import scalafx.scene.control.Slider

object YieldingSlider {
  implicit def sfxSlider2jfx(v: YieldingSlider) = v.delegate
}

class YieldingSlider(override val delegate: jfx.YieldingSlider = new jfx.YieldingSlider) extends Slider {

  /** Constructs a Slider control with the specified slider min, max and current value values. */
  def this(min: Double, max: Double, value: Double) {
    this(new YieldingSlider(min, max, value))
  }
}