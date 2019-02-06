package utils
import org.scalatest.matchers.{MatchResult, Matcher}
import play.api.http.ContentTypes
import play.api.libs.json.{JsValue, Json, OWrites}

object Matchers {
  def beJson: Matcher[Option[String]] =
    (left: Option[String]) =>
      MatchResult(
        left.contains(ContentTypes.JSON),
        left.fold("ContentType was empty")(contentType => contentType + " != " + ContentTypes.JSON),
        "ContentType was " + ContentTypes.JSON
      )

  def equalJsonOf[A](value: A)(implicit writes: OWrites[A]): Matcher[JsValue] =
    (left: JsValue) =>
      MatchResult(
        writes.writes(value).equals(left),
        Json.prettyPrint(left) + " does NOT equal JSON " + Json.prettyPrint(writes.writes(value)),
        left + " equals JSON " + writes.writes(value)
      )
}
