#Tiny Language for ANTLR 4

In [some blog posts](http://bkiers.blogspot.nl/2011/03/creating-your-own-programming-language.html)
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

and finally run the `Main` class which executes the `test.tl` fil which contains:

```
/*
    A script for testing Tiny Language syntax.
*/

// boolean expressions
assert(true || false);
assert(!false);
assert(true && true);
assert(!true || !false);
assert(true && (true || false));

// relational expressions
assert(1 < 2);
assert(666 >= 666);
assert(-5 > -6);
assert(0 >= -1);
assert('a' < 's');
assert('sw' <= 'sw');

// add
assert(1 + 999 == 1000);
assert([1] + 1 == [1,1]);
assert(2 - -2 == 4);
assert(-1 + 1 == 0);
assert(1 - 50 == -49);
assert([1,2,3,4,5] - 4 == [1,2,3,5]);

// multiply
assert(3 * 50 == 150);
assert(4 / 2 == 2);
assert(1 / 4 == 0.25);
assert(999999 % 3 == 0);
assert(-5 * -5 == 25);
assert([1,2,3] * 2 == [1,2,3,1,2,3]);
assert('ab'*3 == "ababab");

// power
assert(2^10 == 1024);
assert(3^3 == 27);

// for- and while statements
a = 0;
for i=1 to 10 do
  a = a + i;
end
assert(a == (1+2+3+4+5+6+7+8+9+10));

b = -10;
c = 0;
while b < 0 do 
  c = c + b;
  b = b + 1;
end
assert(c == -(1+2+3+4+5+6+7+8+9+10));

// if
a = 123;
if a > 200 do
  assert(false);
end

if a < 100 do
  assert(false);
else if a > 124 do
  assert(false);
else if a < 124 do
  assert(true);
else do
  assert(false);
end

if false do
  assert(false);
else do
  assert(true);
end

// functions
def twice(n)
  temp = n + n; 
  return temp; 
end

def squared(n) 
  return n*n; 
end

def squaredAndTwice(n) 
  return twice(squared(n)); 
end

def list()
  return [7,8,9];
end

assert(squared(666) == 666^2);
assert(twice(squared(5)) == 50);
assert(squaredAndTwice(10) == 200);
assert(squared(squared(squared(2))) == 2^2^2^2);
assert(list() == [7,8,9]);
assert(size(list()) == 3);
assert(list()[1] == 8);

// naive bubble sort
def sort(list)
  while !sorted(list) do
  end
end
def sorted(list)
  n = size(list);
  for i=0 to n-2 do
    if list[i] > list[i+1] do
      temp = list[i+1];
      list[i+1] = list[i];
      list[i] = temp;
      return false;
    end
  end
  return true;
end
numbers = [3,5,1,4,2];
sort(numbers);
assert(numbers == [1,2,3,4,5]);

// resursive calls
def fib(n)
  if n < 2 do
    return n;
  else do
    return fib(n-2) + fib(n-1);
  end
end
sequence = [];
for i = 0 to 10 do
  sequence = sequence + fib(i);
end
assert(sequence == [0,1,1,2,3,5,8,13,21,34,55]);

// lists and lookups, `in` operator
n = [[1,0,0],[0,1,0],[0,0,1]];
p = [-1, 'abc', true];

assert('abc' in p);
assert([0,1,0] in n);
assert(n[0][2] == 0);
assert(n[1][1] == n[2][2]);
assert(p[2]);
assert(p[1][2] == 'c');

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
All Assertions have passed.
```

## No Maven?

If you're unfamiliar with Maven, and are reluctant to install it, here's how
to perform all the steps from the (*nix) command line (assuming you're in the
root folder of the project `tiny-language-antlr4`):

Download ANTLR 4:

```bash
wget http://www.antlr.org/download/antlr-4.1-complete.jar
```

Generate the lexer, parser and visitor classes and move them to the other 
`.java` project sources:

```bash
java -cp antlr-4.1-complete.jar \
  org.antlr.v4.Tool src/main/antlr4/tl/antlr4/TL.g4 \
  -package tl.antlr4 \
  -visitor
  
mv src/main/antlr4/tl/antlr4/*.java src/main/java/tl/antlr4
```

Compile all `.java` source files:

```bash
javac -cp antlr-4.1-complete.jar src/main/java/tl/antlr4/*.java
```

Run the `Main` class:

```bash
java -cp src/main/java:antlr-4.1-complete.jar tl.antlr4.Main
```
