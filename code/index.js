function fib(n) {
  let fibArray = [0, 1];
  for (let i = 2; i < n; i++) {
    fibArray.push(fibArray[i - 1] + fibArray[i - 2]);
  }

  return fibArray;
}

function fact(n) {
  if (n < 0) return "Invalid Number";
  if (n < 3) return n ? n : 1;
  let res = 2;
  for (let i = 3; i <= n; i++) {
    res *= i;
  }
  return res;
}

function isPrime(n) {
  if (n < 2) return false;
  // for (let i = 2; i < n; i++) {  O(n)
  for (let i = 2; i * i <= n; i++) {
    //O(sqrt(n))
    if (n % i == 0) return false;
  }
  return true;
}

function isPowerOfTwo(n) {
  if (n < 1) return false;
  // while (n > 1) {
  //   if (n % 2 != 0) return false;
  //   n = n / 2;
  // }
  // return true;  //(log(n))

  return (n & (n - 1)) === 0;
}

function recursiveFib(n) {
  if (n < 2) return n;
  return recursiveFib(n - 1) + recursiveFib(n - 2);
}

function recursiveFact(n) {
  if (!n) return 1;
  return n * recursiveFact(n - 1);
}
// console.log(fib(30));
// console.log(fact(5));
// console.log(isPrime(5));
// console.log(isPowerOfTwo(1));
// console.log(isPowerOfTwo(2));
// console.log(isPowerOfTwo(10));
// console.log(isPowerOfTwo(512));

// cons ole.log(recursiveFib(6));
console.log(recursiveFact(4));
