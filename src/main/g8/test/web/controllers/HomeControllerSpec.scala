package web.controllers

import bindings.GuiceUtils.application
import bindings.GuiceBinding._
import com.eed3si9n.ruchij.BuildInfo
import config.SystemUtilities
import org.joda.time.DateTime
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._
import utils.Matchers._
import utils.TestUtils.waitForResult
import web.responses.models.HealthCheck

class HomeControllerSpec extends PlaySpec {

  "HomeController GET /health" should {
    "return the health check JSON" in {

      val timestamp = DateTime.now()

      implicit val systemUtilities: SystemUtilities = new SystemUtilities {
        override def currentTime(): DateTime = timestamp
      }

      val app = application(classOf[SystemUtilities] -> systemUtilities)

      val request = FakeRequest(GET, "/health")
      val home = route(app, request).value

      status(home) mustBe OK
      contentType(home) must beJson
      contentAsJson(home) must equalJsonOf(HealthCheck())

      waitForResult(app.stop())
    }
  }
}
