import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {

  //dependencies from built-in repos
  val junit = "junit" % "junit" % "4.8.2"

  //dependencies from snapshots repo
  val scalaToolsSnapshots = (
    "Scala-Tools Maven2 Snapshots Repository" at
    "http://scala-tools.org/repo-snapshots"
  )
  val scalatest = "org.scalatest" %% "scalatest" % "1.4.RC3"
  
  //files to go in packaged jars
  val extraResources = "README.md" +++ "LICENSE"
  override val mainResources = super.mainResources +++ extraResources

  //compiler options
  override def compileOptions = super.compileOptions ++
    compileOptions("-deprecation", "-unchecked")
  override def javaCompileOptions =
    JavaCompileOption("-Xlint:unchecked") :: super.javaCompileOptions.toList
}
