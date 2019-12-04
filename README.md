# Tiny Language for ANTLR 4
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

and finally run the `Main` class which executes the `test.tl`:

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
