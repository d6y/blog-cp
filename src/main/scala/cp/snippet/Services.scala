package cp
package snippet

import scala.xml.NodeSeq
import scala.collection.immutable.Stream._
import scala.sys.process._

import net.liftweb.http.js.JsCmds._
import net.liftweb.http.{S, LiftSession, RoundTripInfo }
import net.liftweb.json._

import net.liftweb.common.Loggable
import net.liftweb.http.js.JE._
import net.liftweb.util.Helpers

object Services extends Loggable {

  def render = S.session.map(javascript) openOr NodeSeq.Empty

  private def javascript(s: LiftSession): NodeSeq = Script {
    OnLoad(SetExp(JsVar("server"), s buildRoundtrip services))
  }

  private def services = List[RoundTripInfo](
    "build" -> build _
  )

  private def build(config: JValue) : Stream[JValue] = {
    logger.info(s"Build: $config")

    val cmd = Seq("sh", "/home/richard/bin/update-blog", "jane")
    cmd.lineStream.map(s => JString(s))
  }
}