<img src="dependencies.png"/>

This stage contains all three modules at version 1.0.0 with the Maven build
system.

To build and run, start in `stage1/` and follow these steps:

<pre>maven/stage1$ <strong>mvn install</strong>
...
maven/stage1$ <strong>cd C</strong></pre>
At this stage, the dependency tree looks like this:

<pre>maven/stage1/C$ <strong>mvn dependency:tree -Dverbose</strong>
...
com.implementsblog.runtimeerrors:C:jar:1.0.0
+- com.implementsblog.runtimeerrors:A:jar:1.0.0:compile
+- com.implementsblog.runtimeerrors:B:jar:1.0.0:compile
|  \- (com.implementsblog.runtimeerrors:A:jar:1.0.0:compile - omitted for duplicate)</pre>

Next, to run the example,

<pre>maven/stage1/C$ <strong>mvn package appassembler:assemble</strong>
...
maven/stage1/C$ <strong>./target/appassembler/bin/C</strong></pre>

Which should output the following:

<pre>C-1.0.0 -> A-1.0.0
C-1.0.0 -> B-1.0.0 -> A-1.0.0</pre>
