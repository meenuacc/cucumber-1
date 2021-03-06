name := "cucumber-test2"

organization := "com.waioeka.sbt"

scalaVersion := "2.12.1"

version := "0.0.6"


// Version 0.0.9 - use 1.2.6-SNAPSHOT for Scala 2.12, until 1.2.6 is available.
resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq (
        "info.cukes" % "cucumber-core" % "1.2.6-SNAPSHOT" % "test",
        "info.cukes" %% "cucumber-scala" % "1.2.6-SNAPSHOT" % "test",
        "info.cukes" % "cucumber-jvm" % "1.2.6-SNAPSHOT" % "test",
        "info.cukes" % "cucumber-junit" % "1.2.6-SNAPSHOT" % "test",
        "com.waioeka.sbt" %% "cucumber-runner" % "0.0.9",
        "org.scalatest" %% "scalatest" % "3.0.1" % "test",
        "org.scalacheck" %% "scalacheck" % "1.13.4" % "test")



val framework = new TestFramework("com.waioeka.sbt.runner.CucumberFramework")
testFrameworks += framework

// Configure the arguments.
//testOptions in Test += Tests.Argument(framework,"--monochrome")
testOptions in Test += Tests.Argument(framework,"--glue","")
testOptions in Test += Tests.Argument(framework,"--plugin","pretty")
testOptions in Test += Tests.Argument(framework,"--plugin","html:/tmp/html")
testOptions in Test += Tests.Argument(framework,"--plugin","json:/tmp/json")
