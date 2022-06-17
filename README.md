Reflection
Create an application to analyze and test java classes.
The application will receive as input java classes and it will display their prototypes and perform the tests specified by the @Test annotation.

The main specifications of the application are:

Compulsory (1p)

The input will be a .class file, located anywhere in the file system.
Load the specified class in memory, identifying dynamically its package.
Using reflection, extract as many information about the class (at least its methods).
Using reflection, invoke the static methods, with no arguments, annotated with @Test.
Homework (2p)
The input may be a folder (containing .class files) or a .jar. You must explore it recursively.
Create the complete prototype, in the same manner as javap tool.
Identify all public classes annotated with @Test and invoke the methods annotated with @Test, whether static or not.
If a method requires primitive (at least int) or String arguments, generate mock values for them.
Print a statistics regarding the tests.
