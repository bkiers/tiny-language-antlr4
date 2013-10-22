#Tiny Language for ANTLR 4

In [some blog posts](http://bkiers.blogspot.nl/2011/03/creating-your-own-programming-language.html)
I wrote a while ago, I demonstrated how to create a small dynamically typed programming language
called *Tiny Language* using [ANTLR](http://www.antlr.org/) 3.

However, ANTLR 4 is now the leaner (and meaner) version of the popular parser generator. Since the
changes from v3 to v4 are significant, making *Tiny Language* work using ANTLR 4 is non trivial.
Most notably, ANTLR 4 does not have any tree rewriting anymore. The new version generates listeners
(and/or visitors) that can be used to *walk* the plain parse tree.

This Github project provides a start on how to get Tiny Language working with ANTLR 4. Not all
functionality is implemented in the class 
[`EvalVisitor`](https://github.com/bkiers/tiny-language-antlr4/blob/master/src/main/java/tl/antlr4/EvalVisitor.java)
, but by looking at what *is* implemented one can try the missing functionality.

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

and finally run the `Main` class which executes the `test.tl` fil which contains:

```
a = 10;
b = 32;
c = 42;

if a + b == 42.00001 do
  println(a + " + " + b + " == 42.00001");
else if a + b == c do
  println(a + " + " + b + " == " + c);
else do
  println("nothing was true");
end
```

```bash
mvn -q exec:java
```

Or, combine all the previous commands in a single liner:

```bash
mvn -q antlr4:antlr4 install exec:java
```

which should print:

```
10.0 + 32.0 == 42.0
```
