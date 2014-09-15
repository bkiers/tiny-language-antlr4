/*
    A script for testing Tiny Language syntax.
*/

// boolean expressions
assert(true || false)
assert(!false)
assert(true && true)
assert(!true || !false)
assert(true && (true || false))

// relational expressions
assert(1 < 2)
assert(666 >= 666)
assert(-5 > -6)
assert(0 >= -1)
assert('a' < 's')
assert('sw' <= 'sw')

// add
assert(1 + 999 == 1000)
assert([1] + 1 == [1,1])
assert(2 - -2 == 4)
assert(-1 + 1 == 0)
assert(1 - 50 == -49)
assert([1,2,3,4,5] - 4 == [1,2,3,5])

// multiply
assert(3 * 50 == 150)
assert(4 / 2 == 2)
assert(1 / 4 == 0.25)
assert(999999 % 3 == 0)
assert(-5 * -5 == 25)
assert([1,2,3] * 2 == [1,2,3,1,2,3])
assert('ab'*3 == "ababab")

// power
assert(2^10 == 1024)
assert(3^3 == 27)

// for- and while statements
a = 0
for i=1 to 10 {
  a = a + i
}
assert(a == (1+2+3+4+5+6+7+8+9+10))

b = -10
c = 0
while b < 0 { 
  c = c + b
  b = b + 1
}
assert(c == -(1+2+3+4+5+6+7+8+9+10))

// if
a = 123
if a > 200 {
  assert(false)
}

if a < 100 {
  assert(false)
} else if a > 124 {
  assert(false)
} else if a < 124 {
  assert(true)
} else {
  assert(false)
}

if false {
  assert(false)
} else {
  assert(true)
}

// functions
def twice(n) {
  temp = n + n 
  return temp 
}

def squared(n) {
  return n*n 
}

def squaredAndTwice(n) {
  return twice(squared(n)) 
}

def list() {
  return [7,8,9]
}

assert(squared(666) == 666^2)
assert(twice(squared(5)) == 50)
assert(squaredAndTwice(10) == 200)
assert(squared(squared(squared(2))) == 2^2^2^2)
assert(list() == [7,8,9])
assert(size(list()) == 3)
assert(list()[1] == 8)

// naive bubble sort
def sort(list) {
  while !sorted(list) {
  }
}
def sorted(list) {
  n = size(list)
  for i=0 to n-2 {
    if list[i] > list[i+1] {
      temp = list[i+1]
      list[i+1] = list[i]
      list[i] = temp
      return false
    }
  }
  return true
}
numbers = [3,5,1,4,2]
sort(numbers)
assert(numbers == [1,2,3,4,5])

// resursive calls
def fib(n) {
  if n < 2 {
    return n
  } else {
    return fib(n-2) + fib(n-1)
  }
}
sequence = []
for i = 0 to 10 {
  sequence = sequence + fib(i)
}
assert(sequence == [0,1,1,2,3,5,8,13,21,34,55])

// lists and lookups, `in` operator
n = [[1,0,0],[0,1,0],[0,0,1]]
p = [-1, 'abc', true]

assert('abc' in p)
assert([0,1,0] in n)
assert(n[0][2] == 0)
assert(n[1][1] == n[2][2])
assert(p[2])
assert(p[1][2] == 'c')
