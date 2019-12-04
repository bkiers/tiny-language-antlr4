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
println(3 * 50 == 150); //returns true
assert(4 / 2 == 2);
assert(1 / 4 == 0.25);
assert(999999 % 3 == 0);
assert(-5 * -5 == 25);
assert([1,2,3] * 2 == [1,2,3,1,2,3]);
assert('ab'*3 == "ababab");

// power
assert(2^10 == 1024);
assert(3^3 == 27);
assert(4^3^2 == 262144); // power is right associative
assert((4^3)^2 == 4096);

// lists and lookups, `in` operator
n = [[1,0,0],[0,1,0],[0,0,1]];
p = [-1, 'abc', true];

assert('abc' in p);
assert([0,1,0] in n);
assert(n[0][2] == 0);
assert(n[1][1] == n[2][2]);
assert(p[2]);
assert(p[1][2] == 'c');

println("All Assertions have passed.");
