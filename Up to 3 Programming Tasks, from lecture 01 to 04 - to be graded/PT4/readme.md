How to build this project:
- Open Eclipse
- go to: File->open projects from file system , choose the PT4 directory and click finish
- run the Server Main class as a Java application
- run the Client Main class as a Java application

About the protocol:

The request is divided into a method name and an argument, which are separated
by ':'. The method is specified before ':' and the argument afterwards.

The response is divided into a message and an error code, which are also 
separated by ':'. The message is specified before ':' and the error code
afterwards.
The error code "OK" signals that there is no error
and the error code "ERROR" signals an error. In case of an error, the
response is an error message, describing the error.