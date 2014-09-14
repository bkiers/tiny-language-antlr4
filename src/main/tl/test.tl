a = 10
b = 32
c = 42

if a + b == 42.00001 {
  println(a + " + " + b + " == 42.00001")
} else if a + b == c {
  println(a + " + " + b + " == " + c)
} else {
  println("nothing was true")
}
