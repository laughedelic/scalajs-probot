package laughedelic.probot

import scala.scalajs.js, js.|

/** Minimalistic interface for the [[https://github.com/trentm/node-bunyan
  * bunyan]] logger.
  *
  * @see [[https://github.com/DefinitelyTyped/DefinitelyTyped/blob/master/types/bunyan/index.d.ts]]
  */
@js.native
trait Logger extends js.Object {

  def trace(msg: js.Error | js.Object | js.Any, params: js.Any*): Unit = js.native
  def debug(msg: js.Error | js.Object | js.Any, params: js.Any*): Unit = js.native
  def info(msg: js.Error | js.Object | js.Any, params: js.Any*): Unit = js.native
  def warn(msg: js.Error | js.Object | js.Any, params: js.Any*): Unit = js.native
  def error(msg: js.Error | js.Object | js.Any, params: js.Any*): Unit = js.native
  def fatal(msg: js.Error | js.Object | js.Any, params: js.Any*): Unit = js.native
}

@js.native
trait LoggerWithTarget extends Logger {
  val target: Logger = js.native
  def child(attrs: LoggerChildArgs): LoggerWithTarget = js.native

  /** Calling `log(...)` is equivalent to `log.info(...)` */
  def apply(msg: js.Error | js.Object | js.Any, params: js.Any*): Unit = js.native
}

class LoggerChildArgs(
  val name: js.UndefOr[String] = js.undefined,
  val id: js.UndefOr[String] = js.undefined,
  val installation: js.UndefOr[String] = js.undefined
) extends js.Object
