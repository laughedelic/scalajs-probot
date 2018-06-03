package laughedelic.probot

import scala.scalajs.js, js.|, js.annotation._, js.JSConverters._
import io.scalajs.npm.express
import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.process
import laughedelic.dotenv.Dotenv

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

  private def env(v: String): js.UndefOr[String] =
    process.env.get(v).orUndefined

  /** This is the entry point for the probot application.
    * You can use it as the main method implementation:
    * `def main(args: Array[String]): Unit = ProbotApp.run(plugin)`
    *
    * @param plugins one or several Application implementations
    */
  def run(plugins: Probot.Plugin*): Unit = {
    Dotenv.config()

    val appId = env("APP_ID")
      .getOrElse {
        sys.error("Missing GitHub App ID. Set APP_ID environment variable.")
      }
    val privateKey = env("PRIVATE_KEY")
      .orElse {
        env("PRIVATE_KEY_PATH").map { path =>
          Fs.readFileSync(path).toString("utf-8")
        }
      }
      .getOrElse {
        sys.error(s"Missing private key for GitHub App. Set PRIVATE_KEY or PRIVATE_KEY_PATH environment variable.")
      }

    val opts = new Probot.Options(
      id           = appId.toInt,
      cert         = privateKey,
      secret       = env("WEBHOOK_SECRET"),
      webhookPath  = env("WEBHOOK_PATH"),
      webhookProxy = env("WEBHOOK_PROXY_URL"),
      // NOTE: port should be optional, but for some reason if it's undefined, the default 3000 is not set
      port         = env("PORT").map(_.toInt).orElse(3000),
    )
    val probot = new Probot(opts)

    println(js.JSON.stringify(opts, space = 2))

    probot.setup(plugins.toJSArray)
    probot.start()
  }

}
