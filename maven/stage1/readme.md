This folder contains all three modules at version 1.0.0 with the Maven build
system. At this stage, the dependency tree looks like this:

<pre>
$mvn dependency:tree -Dverbose
...
com.implementsblog.runtimeerrors:C:jar:1.0.0
+- com.implementsblog.runtimeerrors:A:jar:1.0.0:compile
+- com.implementsblog.runtimeerrors:B:jar:1.0.0:compile
|  \- (com.implementsblog.runtimeerrors:A:jar:1.0.0:compile - omitted for duplicate)
</pre>
To build and run, start in `stage1/` and follow these steps:

<pre>
$ mvn install
...
$ cd C
$ mvn package appassembler:assemble
...
$ ./target/appassembler/bin/C
</pre>
Which should output the following:

<pre>
C-1.0.0 -> A-1.0.0
C-1.0.0 -> B-1.0.0 -> A-1.0.0
</pre>
