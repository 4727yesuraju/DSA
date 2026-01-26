function linearSearch(arr, target) {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) return i;
  }
  return -1;
}

function binarySearch(arr, target) {
  let left = 0,
    right = arr.length - 1;

  while (left <= right) {
    let mid = left + Math.floor((right - left) / 2);
    if (arr[mid] === target) return mid;
    else if (arr[mid] > target) right = mid - 1;
    else left = mid + 1;
  }
  return -1;
}

function recursiveBinarySearch(arr, target) {
  return search(arr, target, 0, arr.length);
}

function search(arr, target, left, right) {
  if (left > right) return -1;
  let mid = left + Math.floor((right - left) / 2);

  if (arr[mid] === target) return mid;
  if (target < arr[mid]) return search(arr, target, left, mid - 1);
  else return search(arr, target, mid + 1, right);
}

console.log(linearSearch([1, 2, 3, 4, 5], 1));
console.log(binarySearch([1, 2, 3, 4, 5], 4));
console.log(recursiveBinarySearch([1, 2, 3, 4, 5], 1));
console.log(recursiveBinarySearch([1, 2, 3, 4, 5], 4));
