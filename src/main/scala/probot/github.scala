package laughedelic.probot

import scala.scalajs.js
import laughedelic.octokit.rest.Octokit

/** An extension of the [@octokit/rest Node.js module](https://github.com/octokit/rest.js),
  * which wraps the [GitHub API](https://developer.github.com/v3/) and allows
  * you to do almost anything programmatically that you can do through a web
  * browser.
  *
  * It adds auto-pagination and GraphQL support.
  *
  * @see [[https://github.com/laughedelic/scalajs-octokit]]
  * @see [[https://github.com/octokit/rest.js]]
  */
@js.native
trait GitHubAPI extends Octokit {

  def paginate(
    res: js.Promise[Octokit.AnyResponse],
    callback: Octokit.AnyResponse => Unit,
  ): js.Promise[js.Array[js.Any]] = js.native

  def query(
    query: String,
    variables: js.Dictionary[js.Any] = js.native,
    headers: Octokit.Headers = js.native,
  ): js.Promise[Octokit.AnyResponse] = js.native
}
