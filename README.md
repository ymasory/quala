<img src="https://github.com/downloads/quala/quala/quala_square.png" alt="Quala logo" align="right" width="150" />
# Quala #

> Same bugs different day.

Quala is a quality assurance test suite for the Scala standard library.


## Run tests ##
    cd quala
    sbt
    +update
    +test

## Contributing tests ##
### Available frameworks ###
You can contribute tests using ScalaTests, ScalaCheck, Specs2, or JUnit. You can see examples of each in `src/test/scala/example`.

### Naming ###
If you want to write a test for `scala.collection.immutable.List` you should:

* Put it in a file named `src/test/scala/collection/immutable/List.scala`.
* Put your code in a class/object named `ListTest`.
* Put `ListTest` in the package `quala.collection.immutable.List`.
