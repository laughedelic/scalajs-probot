package laughedelic.probot

import scala.scalajs.js, js.annotation._

/** Helpers for extracting information from the webhook event, which can be
  * passed to GitHub API calls.
  *
  * @param github An authenticated GitHub API client.
  */
@js.native @JSImport("probot", "Context")
class Context(
  event: js.Any,
  val github: GitHubAPI,
  val log: LoggerWithTarget,
) extends js.Object {
  val id: String = js.native

  /** The webhook event payload */
  val payload: ContextPayload = js.native

  /** @return `true` if the actor on the event was a bot */
  def isBot(): Boolean = js.native

  /** @return an object with the `owner` and `repo` params for making API
    * requests against a repository.
    *
    * @param extraFields Params to be merged with the repo params.
    */
  def repo(
    extraFields: js.Object = js.native
  ): ContextRepo = js.native

  /** Return the `owner`, `repo`, and `number` params for making API requests
    * against an issue or pull request. The object passed in will be merged with
    * the repo params.
    *
    * @param extraFields Params to be merged with the issue params.
    */
  def issue(
    extraFields: js.Object = js.native
  ): ContextIssue = js.native

  /** Reads the app configuration from the given YAML file in the `.github`
    * directory of the repository.
    *
    * @param fileName Name of the YAML file in the `.github` directory
    * @param defaultConfig An object of default config options
    * @return Configuration object read from the file
    */
  def config(
    fileName: String,
    defaultConfig: js.Object = js.native
  ): js.Promise[js.Dynamic] = js.native
}

@js.native
trait ContextRepo extends js.Object {
  val owner: String = js.native
  val repo: String = js.native
}

@js.native
trait ContextIssue extends ContextRepo {
  val number: Int = js.native
}


// NOTE: at the moment it's a generic type with a few common fields, but it
// should depend on the particular webhook+action. See
// https://github.com/probot/probot/pull/372#discussion_r180436917
@js.native
trait ContextPayload extends js.Object {
  val repository: PayloadRepository = js.native
  val issue: PayloadIssue = js.native
  val pull_request: PayloadIssue = js.native
  val sender: PayloadSender = js.native
  val action: String = js.native
  val installation: PayloadInstallation = js.native
}

object ContextPayload {
  implicit class ContextPayloadExt(val payload: ContextPayload) extends AnyVal {
    def asDynamic: js.Dynamic = payload.asInstanceOf[js.Dynamic]
  }
}

@js.native
trait PayloadRepository extends js.Object {
  val full_name: String = js.native
  val name: String = js.native
  val owner: PayloadRepositoryOwner = js.native
  val html_url: String = js.native
}

object PayloadRepository {
  implicit class PayloadRepositoryExt(val repo: PayloadRepository) extends AnyVal {
    def asDynamic: js.Dynamic = repo.asInstanceOf[js.Dynamic]
  }
}

@js.native
trait PayloadRepositoryOwner extends js.Object {
  val login: String = js.native
  val name: String = js.native
}

object PayloadRepositoryOwner {
  implicit class PayloadRepositoryOwnerExt(val owner: PayloadRepositoryOwner) extends AnyVal {
    def asDynamic: js.Dynamic = owner.asInstanceOf[js.Dynamic]
  }
}

@js.native
trait PayloadIssue extends js.Object {
  val number: Int = js.native
  val html_url: String = js.native
  val body: String = js.native
}

object PayloadIssue {
  implicit class PayloadIssueExt(val issue: PayloadIssue) extends AnyVal {
    def asDynamic: js.Dynamic = issue.asInstanceOf[js.Dynamic]
  }
}

@js.native
trait PayloadSender extends js.Object {
  val `type`: String = js.native
}

object PayloadSender {
  implicit class PayloadSenderExt(val sender: PayloadSender) extends AnyVal {
    def asDynamic: js.Dynamic = sender.asInstanceOf[js.Dynamic]
  }
}

@js.native
trait PayloadInstallation extends js.Object {
  val id: String = js.native
}

object PayloadInstallation {
  implicit class PayloadInstallationExt(val inst: PayloadInstallation) extends AnyVal {
    def asDynamic: js.Dynamic = inst.asInstanceOf[js.Dynamic]
  }
}
