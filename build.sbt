name:="""JavaParser"""

lazy val root = (project in file(".")).settings(projectSetting)

inThisBuild(List(
  organization := "com.java.parser",
  version      := "0.1.0-SNAPSHOT"
))

javacOptions += "-g:none"

javacOptions ++= Seq("-source", "1.8")

lazy val projectSetting = Seq(
  libraryDependencies ++= Seq(
    "junit" % "junit" % "4.12" % "test",
    "com.novocode" % "junit-interface" % "0.11" % "test"
      exclude("junit", "junit-dep")
  )
)

//javaSource in Compile := baseDirectory.value / "src/test"

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")