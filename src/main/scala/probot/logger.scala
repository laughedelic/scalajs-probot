package laughedelic.probot

import scala.scalajs.js

@js.native
trait Logger extends js.Object {
  def trace(message: String): Unit = js.native
  def debug(message: String): Unit = js.native
  def info(message: String): Unit = js.native
  def warn(message: String): Unit = js.native
  def error(message: String): Unit = js.native
  def fatal(message: String): Unit = js.native
}

class ChildArgs(
  val name: js.UndefOr[String] = js.undefined,
  val id: js.UndefOr[String] = js.undefined,
  val installation: js.UndefOr[String] = js.undefined
) extends js.Object

@js.native
trait LoggerWithTarget extends Logger {
  val target: Logger = js.native
  def child(attrs: ChildArgs): LoggerWithTarget = js.native
}
