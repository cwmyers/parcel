organization := "io.github.cwmyers"

name := "wrap"

version := "0.0.3"

scalaVersion := "2.11.7"

sbtVersion := "0.13.5"

scalacOptions ++= Seq("-Xfatal-warnings", "-feature")

libraryDependencies ++= Seq(
  "org.typelevel"                          %% "cats"                     % "0.4.1",
  "com.chuusai"                            %% "shapeless"                % "2.2.5",
  "org.specs2"                             %% "specs2"                   % "2.4.15" % "test"
)

publishTo := Some(Resolver.file("file",  new File( "/Users/chris.myers/projects/mvn-repo/releases" )) )
