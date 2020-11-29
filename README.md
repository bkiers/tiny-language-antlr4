# Tiny Language for ANTLR 4

In [some blog posts](http://web.archive.org/web/20140519034030/http://bkiers.blogspot.nl/2011/03/creating-your-own-programming-language.html)
I wrote a while ago, I demonstrated how to create a small dynamically typed programming language
called *Tiny Language* using [ANTLR](http://www.antlr.org/) 3.

However, ANTLR 4 is now the leaner (and meaner) version of the popular parser generator. Since the
changes from v3 to v4 are significant, making *Tiny Language* work using ANTLR 4 is non trivial.
Most notably, ANTLR 4 does not have any tree rewriting anymore. The new version generates listeners
(and/or visitors) that can be used to *walk* the plain parse tree.

## Get up and running

First, clone this repository:

```bash
git clone https://github.com/bkiers/tiny-language-antlr4.git
cd tiny-language-antlr4
```

Then generate the lexer, parser and visitor classes using the antlr4 Maven plugin:

```bash
mvn antlr4:antlr4
```

Compile all classes:

```bash
mvn install
```

and finally run the `Main` class (which executes the [`test.tl`](src/main/tl/test.tl) file):

```bash
mvn -q exec:java
```

Or, combine all the previous commands in a single liner:

```bash
mvn -q antlr4:antlr4 install exec:java
```

which should print:

```
All Assertions have passed.
```

## No Maven?

If you're unfamiliar with Maven, and are reluctant to install it, here's how
to perform all the steps from the (*nix) command line (assuming you're in the
root folder of the project `tiny-language-antlr4`):

Download ANTLR 4:

```bash
wget http://www.antlr.org/download/antlr-4.7.1-complete.jar
```

Generate the lexer, parser and visitor classes and move them to the other
`.java` project sources:

```bash
java -cp antlr-4.7.1-complete.jar \
  org.antlr.v4.Tool src/main/antlr4/tl/antlr4/TL.g4 \
  -package tl.antlr4 \
  -visitor

mv src/main/antlr4/tl/antlr4/*.java src/main/java/tl/antlr4
```

Compile all `.java` source files:

```bash
javac -cp antlr-4.7.1-complete.jar src/main/java/tl/antlr4/*.java
```

Run the `Main` class:

```bash
java -cp src/main/java:antlr-4.7.1-complete.jar tl.antlr4.Main
```

## (Un)license

[The Unlicense](http://unlicense.org)
