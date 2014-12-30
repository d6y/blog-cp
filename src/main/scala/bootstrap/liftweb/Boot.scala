package bootstrap.liftweb

import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.sitemap._

class Boot {
  def boot(): Unit =  {

    // where to search snippet
    LiftRules.addToPackages("cp")

    def sitemap = SiteMap(Menu.i("Home") / "index")

    LiftRules.setSiteMapFunc(() ⇒ sitemap)

    val updatedRules = LiftRules.early.append(_.setCharacterEncoding("UTF-8"))
  }
}