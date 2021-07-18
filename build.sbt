scalaVersion := "2.13.3"
name := "classroom"
version := "0.0.1"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
libraryDependencies += "com.novocode" % "junit-interface" % "0.8" % "test->default"
val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.7.8"