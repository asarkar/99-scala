val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "99-scala",
    version := "1.0.0",

    scalaVersion := scala3Version,

    scalafmtPrintDiff := true,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0-M10" % Test,
      "org.scalameta" %% "munit-scalacheck" % "1.0.0-M10" % Test
    ),

    scalacOptions ++= Seq(
        "-encoding", "UTF-8",
        "-feature",
        "-Werror",
        "-explain",
        "-deprecation",
        "-unchecked",
        "-Wunused:all",
        "-rewrite",
        "-indent",
        "-source", "future",
      ),
  )
