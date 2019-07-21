package com.translation

import akka.actor.{ ActorRef, ActorSystem }
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

import scala.concurrent.duration.Duration
import scala.concurrent.{ Await, ExecutionContext, Future }
import scala.util.{ Failure, Success }

object QuickstartServer extends App with TranslationRoutes {

  implicit val system: ActorSystem = ActorSystem("translationAkkaHttpServer")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContext = system.dispatcher

  val translationRegistryActor: ActorRef = system.actorOf(TranslationRegistryActor.props, "translationRegistryActor")
  lazy val routes: Route = userRoutes

  val host = scala.util.Properties.envOrElse("HOST", "localhost")
  val port = scala.util.Properties.envOrElse("PORT", "4301").toInt

  //    val serverBinding: Future[Http.ServerBinding] = Http().bindAndHandle(routes, "localhost", port)
  //  val serverBinding: Future[Http.ServerBinding] = Http().bindAndHandle(routes, "127.0.0.1", port)
  val serverBinding: Future[Http.ServerBinding] = Http().bindAndHandle(routes, host, port)
  //  val serverBinding: Future[Http.ServerBinding] = Http().bindAndHandle(routes, "localhost", 80)

  serverBinding.onComplete {
    case Success(bound) =>
      println(s"Server online at http://${bound.localAddress.getHostString}:${bound.localAddress.getPort}/")
    case Failure(e) =>
      Console.err.println(s"Server could not start!")
      e.printStackTrace()
      system.terminate()
  }

  Await.result(system.whenTerminated, Duration.Inf)
}
