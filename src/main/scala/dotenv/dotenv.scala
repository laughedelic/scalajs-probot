package laughedelic.dotenv

import scala.scalajs.js, js.annotation._

@js.native @JSImport("dotenv", JSImport.Default)
object Dotenv extends js.Object {

  // Load env vars from the `.env` file
  def config(): Unit = js.native
}
