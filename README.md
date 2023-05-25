# RF Java :: Robot Framework Remote Server in Java

## Requirements

- JDK 8
- Maven

## Usage

1. Open the project with IntelliJ IDEA. 
2. Execute the main method in the class `com.rfjava.Main`.
3. The Remote server is ready!

The server can be packaged as a standalone jar with

```bash
mvn package
```

## Notes

The available keywords are implemented in the class `com.rfjava.TestLibrary`.

A keyword must have a `com.rfjava.Keyword` annotation and a `com.rfjava.Doc` annotation. It must return an instance of `com.rfjava.RobotResult`.

The Remote server supports keywords with several arguments of most types [supported by XML-RPC](https://ws.apache.org/xmlrpc/types.html).

Arrays of arbitrary objects are not supported. Only arrays of strings, ints, and doubles.

Any composite object whose leafs are not elementary types must be sent encoded as JSON. This includes Python lists of lists, dictionaries with non-elementary values and arbitrary Python objects.

On the Java side you can use GSON to deserialize the JSON strings.
