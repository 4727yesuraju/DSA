function cartesiannProduct(arr1, arr2) {
  let result = [];

  for (let i = 0; i < arr1.length; i++) {
    for (let j = 0; j < arr2.length; j++) {
      result.push([arr1[i], arr2[j]]);
    }
  }
  return result;
}

function stairCase(n) {
  let noOfWays = [1, 2, 3];

  for (let i = 4; i <= n; i++) {
    console.log(noOfWays[i - 2]);
    noOfWays.push(noOfWays[i - 2] + noOfWays[i - 3]);
    console.log(noOfWays);
  }
  return noOfWays[n - 1];
}
console.log(cartesiannProduct([1, 2], [3, 4, 5]));
console.log(stairCase(5));
