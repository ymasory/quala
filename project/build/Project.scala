import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {

  //dependencies from built-in repos
  val junit = "junit" % "junit" % "4.8.2"
  val junitInterface = "com.novocode" % "junit-interface" % "0.6"

  val scalacheck = "org.scala-tools.testing" %% "scalacheck" % "1.8"
  val specs2 = "org.specs2" %% "specs2" % "1.3" 

  // dependencies from snapshots repo
  val scalaToolsSnapshots = (
    "Scala-Tools Maven2 Snapshots Repository" at
    "http://scala-tools.org/repo-snapshots"
  )
  val scalatest = "org.scalatest" %% "scalatest" % "1.4.1"

  //junit
  override def testOptions = 
    super.testOptions ++ 
    Seq(TestArgument(TestFrameworks.JUnit, "-q", "-v"))
  
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
}
