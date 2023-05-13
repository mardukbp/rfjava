# RF Java :: Robot Framework Remote Server in Java

## Requirements

- JDK 8
- Maven

## Usage

1. Open the project with IntelliJ IDEA. 
2. Execute the main method in the Main class.
3. The Remote server is ready!

The available keywords are implemented in the class TestLibrary.

## Notes

A keyword must have a Keyword annotation and a Doc annotation. It must return an instance of RobotResult.

The Remote server supports keywords with several arguments of most types supported by XML-RPC.

Arrays of arbitrary objects are not supported. Only arrays of strings, ints, and doubles.

Any composite object whose leafs are not elementary types must be sent encoded as JSON. This includes Python lists of lists, dictionaries and arbitrary Python objects.

On the Java side you can use GSON to deserialize the JSON strings.
