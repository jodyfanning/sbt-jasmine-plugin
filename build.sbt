sbtPlugin := true

name := "sbt-jasmine-plugin"

organization := "com.kevatkartano"

version := "0.1"

libraryDependencies += "org.mozilla" % "rhino" % "1.7R4"

// don't bother publishing javadoc
publishArtifact in (Compile, packageDoc) := false

publishTo <<= (version) { version: String =>
    val publishType = if (version.endsWith("SNAPSHOT")) "snapshots" else "releases"
    Some(
        Resolver.file(
            "jodyfanning github " + publishType,
            file(System.getProperty("user.home") + "/jodyfanning.github.com/maven/repo-" + publishType)
        )
    )
}
