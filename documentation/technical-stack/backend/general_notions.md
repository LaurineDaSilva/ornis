# General back-end notions

## `pom.xml`

A Project Object Model or POM is the fundamental unit of work in Maven. It is an XML file that contains information about the project and configuration details used by Maven to build the project. It contains default values for most projects. Examples for this is the build directory, which is target; the source directory, which is src/main/java; the test source directory, which is src/test/java; and so on. When executing a task or goal, Maven looks for the POM in the current directory. It reads the POM, gets the needed configuration information, then executes the goal.

Some of the configuration that can be specified in the POM are the project dependencies, the plugins or goals that can be executed, the build profiles, and so on. Other information such as the project version, description, developers, mailing lists and such can also be specified.

## JAR

A JAR ("Java archive") file is a package file format typically used to aggregate many Java class files and associated metadata and resources (text, images, etc.) into one file for distribution.

A JAR file allows Java runtimes to efficiently deploy an entire application, including its classes and their associated resources, in a single request. JAR file elements may be compressed, shortening download times.

A JAR file may contain a manifest file, that is located at META-INF/MANIFEST.MF. The entries in the manifest file describe how to use the JAR file. For instance, a Classpath entry can be used to specify other JAR files to load with the JAR.

It serves as a container that holds Java class files, resources, and metadata related to the application. JAR files make it easy to distribute Java software because they can bundle multiple files into a single archive.

### JAR key features

- Container Format: JAR files are essentially ZIP archives with a specific structure. They can contain compiled Java classes, images, configuration files, and other resources necessary for a Java application.

- Executable and Libraries: JAR files can be either executable (containing a main class with a main method that can be executed) or libraries (containing classes and resources to be used by other Java applications).

- Java Platform Independence: JAR files are platform-independent, meaning they can be run on any system with a Java Virtual Machine (JVM) installed, provided that the application's dependencies are satisfied.

- Manifest File: A JAR file can include a special file called the "Manifest," which contains metadata about the JAR and its contents, such as the main class to be executed, version information, and dependencies.

- Classpath: JAR files are commonly used to organize and distribute Java libraries. They can be added to the classpath, making it easier for developers to include external libraries in their Java projects.
