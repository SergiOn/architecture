lazy val akkaHttpVersion = "10.1.9"
lazy val akkaVersion    = "2.6.0-M4"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "com.translation",
      scalaVersion    := "2.13.0"
    )),
    name := "scala-translation",
    version := "1.0",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,

      "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"            % "3.0.8"         % Test
    )
  )
