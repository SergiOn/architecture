package com.translation

import akka.actor.{ ActorRef, ActorSystem }
import akka.event.Logging
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.{ delete, get, post }
import akka.http.scaladsl.server.directives.PathDirectives.path
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.pattern.ask
import akka.util.Timeout
import com.translation.TranslationRegistryActor.{ GetTranslation, GetTranslations }
import spray.json.DefaultJsonProtocol

import scala.concurrent.Future
import scala.concurrent.duration._

trait TranslationRoutes extends SprayJsonSupport {
  import DefaultJsonProtocol._

  implicit val system: ActorSystem

  lazy val log = Logging(system, classOf[TranslationRoutes])

  val translationRegistryActor: ActorRef

  // Required by the `ask` (?) method below
  implicit lazy val timeout = Timeout(5.seconds) // usually we'd obtain the timeout from the system's configuration

  lazy val userRoutes: Route =
    pathEndOrSingleSlash {
      complete("Home page: Scala")
    } ~
      pathPrefix("translations") {
        concat(
          pathEnd {
            get {
              val translations: Future[Map[String, String]] = (translationRegistryActor ? GetTranslations).mapTo[Map[String, String]]
              complete(translations)
            }
          },
          path(Segment) { language =>
            get {
              val maybeUser: Future[Option[String]] = (translationRegistryActor ? GetTranslation(language)).mapTo[Option[String]]
              rejectEmptyResponse {
                complete(maybeUser)
              }
            }
          })
      }
}
