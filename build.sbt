name := "code-test-cart-price"

version := "0.1"

scalaVersion := "2.12.3"

val circeVersion = "0.9.0-M1"

libraryDependencies ++= Seq(
  "io.circe"                         %% "circe-core"              % circeVersion,
  "io.circe"                         %% "circe-generic"           % circeVersion,
  "io.circe"                         %% "circe-parser"            % circeVersion,
  "org.scalatest"                    %% "scalatest"               % "3.0.3"            % "test",
  "org.scalacheck"                   %% "scalacheck"              % "1.13.5"           % "test"
)

mainClass in(Compile, run) := Some("com.codetest.app.Main")