package laughedelic.probot

import scala.scalajs.js
import laughedelic.octokit.rest.Octokit

@js.native
trait Context extends js.Object {
  /** An authenticated GitHub API client */
  val github: Octokit = js.native

  /** The webhook event payload */
  val payload: ContextPayload = js.native

  /** A logger */
  val log: LoggerWithTarget = js.native

  /** Returns a boolean if the actor on the event was a bot */
  def isBot(): Boolean = js.native

  /**
   * Return the `owner` and `repo` params for making API requests against a
   * repository.
   *
   * @param extraFields Params to be merged with the repo params.
   */
  def repo(
    extraFields: js.Object = js.native
  ): ContextRepo = js.native

  /**
   * Return the `owner`, `repo`, and `number` params for making API requests
   * against an issue or pull request. The object passed in will be merged with
   * the repo params.
   *
   * @param extraFields Params to be merged with the issue params.
   */
  def issue(
    extraFields: js.Object = js.native
  ): ContextIssue = js.native

  /**
   * Reads the app configuration from the given YAML file in the `.github`
   * directory of the repository.
   *
   * @param fileName Name of the YAML file in the `.github` directory
   * @param defaultConfig An object of default config options
   * @return Configuration object read from the file
   */
  def config(
    fileName: String,
    defaultConfig: js.Object = js.native
  ): js.Promise[js.Object] = js.native
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


@js.native
trait ContextPayload extends js.Object {
  val repository: PayloadRepository = js.native
  val issue: PayloadIssue = js.native
  val pull_request: PayloadIssue = js.native
  val sender: PayloadSender = js.native
  val action: String = js.native
  val installation: PayloadInstallation = js.native
}

@js.native
trait PayloadRepository extends js.Object {
  val full_name: String = js.native
  val name: String = js.native
  val owner: PayloadRepositoryOwner = js.native
}

@js.native
trait PayloadRepositoryOwner extends js.Object {
  val login: String = js.native
  val name: String = js.native
}

@js.native
trait PayloadIssue extends js.Object {
  val number: Int = js.native
}

@js.native
trait PayloadSender extends js.Object {
  val `type`: String = js.native
}

@js.native
trait PayloadInstallation extends js.Object {
  val id: String = js.native
}
