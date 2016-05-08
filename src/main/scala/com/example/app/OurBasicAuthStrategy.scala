package com.example.app

/**
  * Created by horiba on 16/05/08.
  */
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import org.scalatra.auth.strategy.{BasicAuthStrategy, BasicAuthSupport}
import org.scalatra.auth.{ScentryConfig, ScentryStrategy, ScentrySupport}
import org.scalatra.ScalatraBase


class OurBasicAuthStrategy(protected override val app: ScalatraBase)
  extends ScentryStrategy[User] {
  private def request = app.enrichRequest(app.request)
  val userName = "scalatra" // TODO: Get this from POST body or whatever you're using
  val password = "scalatra" // TODO: Get this from POST body or whatever you're using

  def authenticate()(implicit request: HttpServletRequest, response: HttpServletResponse): Option[User] = {
    if(userName == "scalatra" && password == "scalatra") Some(User("scalatra"))
    else None
  }
}