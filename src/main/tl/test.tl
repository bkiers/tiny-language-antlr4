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
