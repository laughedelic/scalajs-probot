package laughedelic.probot

import scala.scalajs.js, js.|, js.annotation._
import io.scalajs.npm.express

@js.native @JSImport("probot", "Probot")
class Probot(
  options: Probot.Options = js.native
) extends js.Object {

  val server: express.Application = js.native
  val webhook: js.Any = js.native
  val logger: Logger = js.native

  def errorHandler(err: js.Error): Unit = js.native

  def receive(event: WebhookEvent): js.Promise[js.Any] = js.native

  def load(plugin: String | Probot.Plugin): Application = js.native

  def setup(
    apps: js.Array[String] | js.Array[Probot.Plugin]
  ): express.Application = js.native

  def start(): Unit = js.native
}

object Probot {

  type Plugin = js.Function1[Application, Unit]

  class Options(
    val id: Int,
    val cert: String,
    val secret: js.UndefOr[String] = js.undefined,
    val webhookPath: js.UndefOr[String] = js.undefined,
    val webhookProxy: js.UndefOr[String] = js.undefined,
    val port: js.UndefOr[Int] = js.undefined,
  ) extends js.Object
}
