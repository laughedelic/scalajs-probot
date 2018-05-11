package laughedelic.probot

import scala.scalajs.js, js.|
import io.scalajs.npm.express

@js.native
trait Robot extends js.Object {

  /** A logger */
  val log: LoggerWithTarget = js.native

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
    event: String | js.Array[String],
    callback: Context => Unit
  ): Unit = js.native

  /** Get an [[http://expressjs.com express]] router that can be used to expose
    * HTTP endpoints.
    *
    * @param path the prefix for the routes
    * @return an express [[express.Router]] to expose new HTTP endpoints
    * @see [[http://expressjs.com/en/4x/api.html#router]]
    */
  def route(path: String): express.Router = js.native
}
