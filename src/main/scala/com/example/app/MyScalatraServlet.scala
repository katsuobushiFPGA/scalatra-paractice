package com.example.app

import org.scalatra
import org.scalatra._
import org.scalatra.scalate.ScalateSupport

class MyScalatraServlet extends ScalatraServlet with ScalateSupport with AuthenticationSupport{

  get("/auth") {
    authenticate
    if(!isAuthenticated) {
      <html>
        <h1>Unauthorized.</h1>
      </html>
    }
    <html>
      <body>
        <h1>Hello from Scalatra</h1>
        <p>You are authenticated.</p>
      </body>
    </html>
  }

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  get("/test") {
    <html>
      <body>
        <h1>test page</h1>
      </body>
    </html>
  }
  /* Named parameters*/
  get("/hello/:name") {
    <p>Hi,Hello,{params("name")}</p>
  }
  /* Wildcards */
  get("/test/*/nest/*") {
    multiParams("splat") // Seq("1","2")
  }
  /* Regular expressions */
  get("""^\/f(".*)/b(.*)""".r) {
    // Matches "GET /foo/bar"
    multiParams("captures") // == Seq("oo","ar")
  }
  get("/foo",request.getRemoteHost == "127.0.0.1") {
    request.getAuthType + "\n" + request.getRemoteUser + "\n"
  }
  override def error(handle:scalatra.ErrorHandler) = {

  }
}
