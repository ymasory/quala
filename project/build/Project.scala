import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {

  shout("configuring with Scala v" + vs)

  val acceptedVersions = List("2.9.0.RC3", "2.8.1")
  if(acceptedVersions contains vs == false)
    throw new RuntimeException("Quala doesn't support Scala " + version)

  //dependencies from built-in repos without binary compatibility issues
  val junit = "junit" % "junit" % "4.8.2"
  // val scalacheck = "org.scala-tools.testing" % "scalacheck_2.9.0.RC2" % "1.8"

  // dependencies from snapshots repo
  val scalaToolsSnapshots = (
    "Scala-Tools Maven2 Snapshots Repository" at
    "http://scala-tools.org/repo-snapshots"
  )

  val scalatest = {
    vs match {
      case "2.8.1" => "org.scalatest" % "scalatest" % "1.3"
      case "2.9.0.RC3" => "org.scalatest" %% "scalatest" % "1.4.RC3"
    }
  }
  
  //turn down logging a bit
  // log.setLevel(Level.Warn)
  log.setTrace(2)

  //files to go in packaged jars
  val extraResources = "README.md" +++ "LICENSE"
  override val mainResources = super.mainResources +++ extraResources

  //compiler options
  override def compileOptions = super.compileOptions ++
    compileOptions("-deprecation", "-unchecked")
  override def javaCompileOptions =
    JavaCompileOption("-Xlint:unchecked") :: super.javaCompileOptions.toList

  def shout(msg: String) = {
    val banner = (1 to 80).map(i => "#").mkString
    println(banner)
    println("Quala: " + msg)
    println(banner)
  }

  def vs = crossScalaVersionString
}
