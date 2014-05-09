# Dependencies Changing over Time

This directory contains a series of directories that represents the evolving
state of a small set of modules, `A`, `B`, and `C`, where the dependency graph
looks like this:

Each stage marks a time when a new version of one or more of the modules has 
been released. Each `stage` directory contains an image of the dependency tree
that includes versions specific to that stage. In later stages (`stage3/` and
`stage4`), version conflicts arrise. These conflicts are either manifested as a
runtime exception or a compile time exception, depending on the build tool used
(either Maven or Gradle in this example) and how the build is configured.

Each stage depends on the build output previous stages (irrespective of build 
tool). Module `C` contains a class with a `main` method, and each build tool is
configured to run it on command, as described below.

## Building with Maven (3.2.1)

To build and run, start in `stage*/` and follow these steps:

<pre>$ mvn install
...
$ cd C</pre>
Next, to run the example,

<pre>$ mvn package appassembler:assemble
...
maven/stage1/C$ ./target/appassembler/bin/C</pre>

For stages 3 and 4, running `C` should cause runtime exceptions.

## Building with Gradle (1.12)

To build and run, start in `stage*/` and follow these steps:

In each directory, `A/`, `B/`, and `C/`, run
<pre>$ gradle pTML</pre>
Note that `pTML` is short for `publishToMavenLocal`.

Go to the `C/` directory and run the `C#main` by typing
<pre>$ gradle run</pre>


