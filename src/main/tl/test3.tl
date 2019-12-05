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
assert(squared(squared(squared(2))) == ((2^2)^2)^2);
assert(list() == [7,8,9]);
assert(size(list()) == 3);
assert(list()[1] == 8);

println(squared(666));
println(twice(squared(5)));
println(list());
println(size(list()));
println(list()[1]);

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
print("Unsorted Numbers Array: ");
println(numbers);
sort(numbers);
assert(numbers == [1,2,3,4,5]);

if false do
    assert(false);
    else do
    assert(true);
    print("Sorted Numbers Array: ");
    println(numbers); //returns sorted numbers
end

// resursive calls
def fib(n)
  if n < 2 do
    return n;
  else do
    return fib(n-2) + fib(n-1);
  end
end
sequence = [];
print("Empty Sequence List before Recursion: ");
println(sequence);

for i = 0 to 10 do
  sequence = sequence + fib(i);
end
assert(sequence == [0,1,1,2,3,5,8,13,21,34,55]);

if false do
    assert(false);
    else do
    print("Sequence List after Recursion: ");
    println(sequence);
  end