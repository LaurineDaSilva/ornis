# API and Rest API

#  _Application Programming Interface_ (API)

It is a software intermediary that allows two applications to communicate with each other.

## Basic definition

APIs are a set of definitions and protocols through which two softwares will interact without human invervention. They are abstractions defined by an interface's description and its behaviour.

- Application stands for any service a developer or another application wants to interact with.

- Programming is a computer function to which a developer gives instructions and that will interact with the app in our place, to get data automatically at certain times for instance.

- Interface is the entry point through which it is possible to interact with the app.

APIs can stand as an interface between a database and an app.

#  _REpresentational Programming Interface_ (Rest API)

It is a software architecture that imposes conditions on how an API should work. It works on the client-server relation.

REST API uses the HTTP protocol = The client asks for a resource with the GET method and the server sends a response.
This response can be in severals formats such as XML, HTML, YAML, JSON....

Read the API documentation to see available formats. You might need to specify the key and value that are necessary to obtain the data in the format you need. For instance, the eBird API offers several formats for birds taxonomy. You can obtain a response in CSV or in JSON. CSV is the default. To change the response format, `fmt=json` must be specified in the request.

## Using an external RESTful API in a Java program

In the Service layer, a RestTemplate object must be instanciated. It must be marked with the @Autowired annotation, which allows dependency injections. Find more info [here](https://hens.medium.com/how-to-consume-an-external-api-using-java-spring-boot-and-gradle-8c3d42d2565b).

# JSON
The JSON format has become the most used format because it is a lightweight data-interchange format.

JSON is easy for humans to read and write and easy for machines to parse and generate.
And although it is based on a JavaScript syntax, it is an independant language.

JSON is built on two data structures:

1. An object: a collection of name/value pairs (or key/value pairs) between {...}.
2. An array: a ordered list of values between [...]

## Types of value for JSON:
*  string
*  number
*  null (no value)
*  object
*  array
*  boolean

# Consuming an external API with Java Spring Boot (Maven)

* Example with [Gradle](https://hens.medium.com/how-to-consume-an-external-api-using-java-spring-boot-and-gradle-8c3d42d2565b) but it works with Maven too.
