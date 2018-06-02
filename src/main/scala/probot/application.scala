package laughedelic.probot

import scala.scalajs.js, js.|, js.annotation._, js.JSConverters._
import scala.concurrent.{ Future, ExecutionContext }
import io.scalajs.npm.express

@js.native @JSImport("probot", "Application")
class Application(
  options: Application.Options = js.native
) extends js.Object {

  /** A logger */
  val log: LoggerWithTarget = js.native

  val app: () => String = js.native
  val router: express.Router = js.native
  val catchErrors: js.UndefOr[Boolean] = js.native

  // TODO: define Cache
  // val cache: Cache = js.native
  // TODO: add dependency on promise-events?
  // val events: EventEmitter = js.native

  /** Listen for [[https://developer.github.com/webhooks GitHub webhooks]],
    * which are fired for almost every significant action that users take on
    * GitHub.
    *
    * @param event the name of the
    * [[https://developer.github.com/webhooks/#events GitHub webhook event]].
    * Most events also include an "action". For example, the
    * [[https://developer.github.com/v3/activity/events/types/#issuesevent
    * `issues`]] event has actions of `assigned`, `unassigned`, `labeled`,
    * `unlabeled`, `opened`, `edited`, `milestoned`, `demilestoned`, `closed`,
    * and `reopened`. Often, your bot will only care about one type of action,
    * so you can append it to the event name with a `.`, like `issues.closed`.
    * @param callback a function to call when the webhook is received.
    */
  def on(
    eventName: String | js.Array[String],
    callback: js.Function1[Context, js.Promise[js.Any]],
  ): Unit = js.native

  /** Get an [[http://expressjs.com express]] router that can be used to expose
    * HTTP endpoints.
    *
    * @param path the prefix for the routes
    * @return an express [[express.Router]] to expose new HTTP endpoints
    * @see [[http://expressjs.com/en/4x/api.html#router]]
    */
  def route(path: String = js.native): express.Router = js.native

  /** Authenticate and get a GitHub client that can be used to make API calls.
    * You'll probably want to use `context.github` instead.
    *
    * @param id - ID of the installation, which can be extracted from
    * `context.payload.installation.id`. If called without this parameter, the
    * client will authenticate [as the app](https://developer.github.com/apps/building-integrations/setting-up-and-registering-github-apps/about-authentication-options-for-github-apps/#authenticating-as-a-github-app)
    * instead of as a specific installation, which means it can only be used for
    * [app APIs](https://developer.github.com/v3/apps/).
    * @return An authenticated GitHub API client
    */
  def auth(
    id: Int = js.native,
    log: LoggerWithTarget = js.native
  ): js.Promise[GitHubAPI] = js.native
}

object Application {

  class Options(
    val app: () => String,
    val cache: js.Any, // Cache
    val router: js.UndefOr[express.Router] = js.undefined,
    val catchErrors: Boolean,
  ) extends js.Object

  implicit class ApplicationExt(val app: Application) extends AnyVal {

    def on(eventNames: String*)(
      callback: Context => Future[js.Any]
    )(implicit ec: ExecutionContext): Unit =
      app.on(
        eventNames.toJSArray,
        callback(_).toJSPromise
      )
  }
}
