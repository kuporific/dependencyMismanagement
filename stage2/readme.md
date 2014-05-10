# Stage 2

<img src="dependencies.png" style="margin-left:auto;margin-right:auto;"/>

## Maven

Build succeeds, but fails with a runtime error:
<pre>
Exception in thread "main" java.lang.NoSuchMethodError:
    com.implementsblog.a.A.call(Ljava/lang/String;)Ljava/lang/String;
        at com.implementsblog.b.B.call(B.java:7)
        at com.implementsblog.c.C.call(C.java:9)
        at com.implementsblog.c.C.main(C.java:13)
</pre>

## Gradle

Build of `A` and `B` succeed, but building `C` fails with
<pre>
error: method call in class A cannot be applied to given types;
    return "C-1.0.2 -> " + A.call() + "\n"
                            ^
  required: String
  found: no arguments
  reason: actual and formal argument lists differ in length
</pre>

