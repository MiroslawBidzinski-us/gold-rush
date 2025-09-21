# gold_rush_resources

A repository of resources needed to complete tasks in software engineering classes.

## Table of contents
- **gold_rush__empty_prj.zip** — an empty Gradle project;
  you can import it into any IDE or work with it directly from the command line (see below)
- _comming soon..._


## Notes

### How to work with Gradle project (basics)

To build the application, use the gradlew command-line tool. Below are some common operations
(_note_: on Windows, use `gradlew.bat` instead of `./gradlew`).

- `./gradlew` -- build project
- `./gradlew clean` -- clean project (removes _build_ directory)
- `./gradlew jar` -- build project and produce JAR file

To run the application, execute the following command from the project’s root directory:

`java -cp build/libs/gold_rush-0.1.jar edu.io.Main`
