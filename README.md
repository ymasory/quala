# Quala - Quality Assurance test suite for the Scala standard library #
## Run tests ##
    cd quala
    sbt
    +update
    +test

## Contributing tests ##
### Available frameworks ###
You can contribute tests using ScalaTests, ScalaCheck, Specs, or JUnit. You can see examples of each in `src/test/scala/example`.

### Naming ###
If you want to write a test for `scala.collection.immutable.List` you should:
* Put it in a file named `src/test/scala/collection/immutable/List.scala`.
* Put your code in a class/object named `ListTest`.
* Put `ListTest` in the package `quala.collection.immutable.List`.
