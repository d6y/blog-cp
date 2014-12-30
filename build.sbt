name := "BlogCP"

version := "1.0.0-SNAPSHOT"

organization := "com.dallaway"

scalaVersion := "2.11.4"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)

jetty()

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/groups/public"

libraryDependencies ++= {
  val liftVersion = "3.0-M2"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile"
  )
}


