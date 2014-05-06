<img src="dependencies.png"/>

This stage contains the modules `A-2.0.0`, `B-1.0.2`, and `C-1.0.2` built with
the Maven build system. This depends on the outputs of Stage 1
(<code>maven/stage1$ <strong>mvn install</strong></code>) and Stage 2
(<code>maven/stage2$ <strong>mvn install</strong></code>).

To build and run, start in `stage3/` and follow these steps:

<pre>maven/stage3$ <strong>mvn install</strong>
...
maven/stage3$ <strong>cd C</strong></pre>
At this stage, the dependency tree looks like this:

<pre>maven/stage3/C$ <strong>mvn dependency:tree -Dverbose</strong>
...
com.implementsblog.runtimeerrors:C:jar:1.0.2
+- com.implementsblog.runtimeerrors:A:jar:1.0.0:compile
\- com.implementsblog.runtimeerrors:B:jar:1.0.2:compile
   \- (com.implementsblog.runtimeerrors:A:jar:2.0.0:compile - omitted for conflict with 1.0.0)</pre>

Next, to run the example,

<pre>maven/stage3/C$ <strong>mvn package appassembler:assemble</strong>
...
maven/stage3/C$ <strong>./target/appassembler/bin/C</strong></pre>

Which should output the following:

<pre>Exception in thread "main" java.lang.NoSuchMethodError: com.implementsblog.a.A.call(Ljava/lang/String;)Ljava/lang/String;
             at com.implementsblog.b.B.call(B.java:7)
             at com.implementsblog.c.C.call(C.java:9)
             at com.implementsblog.c.C.main(C.java:13)</pre>

Maven's ["nearest definition"](http://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html)
strategy has finally bit us.