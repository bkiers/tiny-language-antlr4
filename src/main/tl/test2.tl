// if
a = 123;

if a > 200 do
  assert(false);
end
println(a > 200);

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
  println("Wrong");
else do
  assert(true);
  println("Correct"); //prints out Correct
end

// for- and while statements
a = 0;
for i=1 to 10 do
  a = a + i;
end
assert(a == (1+2+3+4+5+6+7+8+9+10));

if false do
assert(false);
else do
println(a); //returns 55.0
end

b = -10;
c = 0;
while b < 0 do
  c = c + b;
  b = b + 1;
end
assert(c == -(1+2+3+4+5+6+7+8+9+10));
println(c); //returns -55.0