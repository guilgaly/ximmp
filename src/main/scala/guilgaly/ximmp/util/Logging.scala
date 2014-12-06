package guilgaly.ximmp.util

import org.log4s._

/**
 * Extend logging to include a logger, named after the class's qualified name.
 */
trait Logging {

  private[this] val _logger = getLogger(getClass)

  /** @return The logger. */
  protected[this] def logger: Logger = _logger
}
